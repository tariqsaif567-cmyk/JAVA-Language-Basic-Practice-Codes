package SaraKaam;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import SnakeDeluxe;
import SnakeDeluxe.Theme;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.awt.Point;

/**
 * SnakeDeluxe - Modern styled Swing Snake with upgrades: - Menu, Options,
 * Difficulty - Themes/Skins, Levels (simple maze), Power-ups (speed boost,
 * slow, shield) - Score + persistent leaderboard (top 10) - Sound effects
 * (optional; place WAV files in resources)
 *
 * Put this file into package snakefull and run from NetBeans or command-line.
 *
 * Resources expected at: src/snakefull/resources/ - eat.wav (sound when eating)
 * - gameover.wav (sound on game over) - boost.wav (power-up pick) - theme.wav
 * (optional background music, loops) - icon.png (window icon) (optional)
 *
 * Leaderboard file created at: USER_HOME/.snake_deluxe_leaderboard.txt
 */
public class SnakeDeluxe extends JPanel implements ActionListener, KeyListener {

    // Grid and drawing
    private final int TILE = 28;
    private final int COLS = 20;
    private final int ROWS = 20;
    private final int GAME_W = COLS * TILE;
    private final int GAME_H = ROWS * TILE;

    // UI
    private JFrame frame;
    private Timer timer;
    private int baseDelay = 140;
    private int minDelay = 50;

    // Game state
    private LinkedList<Point> snake = new LinkedList<>();
    private Point food;
    private char dir = 'R';
    private boolean running = false;
    private boolean paused = false;
    private boolean gameOver = false;

    // Score & leaderboard
    private int score = 0;
    private final Path leaderboardFile = Paths.get(System.getProperty("user.home"), ".snake_deluxe_leaderboard.txt");
    private final int LEADERBOARD_SIZE = 10;

    // Powerups
    private boolean shieldActive = false;
    private long shieldEndTime = 0;
    private long slowEndTime = 0;
    private long boostEndTime = 0;

    // Theme / visuals
    enum Theme {
        MODERN, NEON, RETRO
    }

    private Theme theme = Theme.MODERN;

    // Levels (mazes). 0 = empty, 1 = wall
    private int[][] map = new int[ROWS][COLS];
    private int levelIndex = 0;
    private final List<int[][]> levels = new ArrayList<>();

    // Resources
    private Clip musicClip = null;

    // Random
    private final Random rnd = new Random();

    // UI needed sizes
    private final int HUD_W = 220;

    // Fonts
    private final Font hudFont = new Font("Segoe UI", Font.BOLD, 14);
    private final Font titleFont = new Font("Segoe UI", Font.BOLD, 28);

    // Constructor
    public SnakeDeluxe(JFrame f) {
        this.frame = f;
        setPreferredSize(new Dimension(GAME_W + HUD_W, GAME_H));
        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(this);

        createLevels();
        loadLeaderboard(); // ensures file exists
        timer = new Timer(baseDelay, this);
        timer.start();
        initGame();

        // try to play ambient music (optional)
        playLoop("/snakefull/resources/theme.wav");
    }

    // ---------- Game init / spawn ----------
    private void initGame() {
        snake.clear();
        int sx = COLS / 2, sy = ROWS / 2;
        snake.add(new Point(sx, sy));
        snake.add(new Point(sx - 1, sy));
        snake.add(new Point(sx - 2, sy));
        dir = 'R';
        score = 0;
        running = true;
        paused = false;
        gameOver = false;
        shieldActive = false;
        shieldEndTime = slowEndTime = boostEndTime = 0;
        setLevel(levelIndex);
        spawnFood();
        setDelay(baseDelay);
    }

    private void setLevel(int idx) {
        if (idx < 0 || idx >= levels.size()) {
            idx = 0;
        }
        levelIndex = idx;
        int[][] chosen = levels.get(idx);
        for (int r = 0; r < ROWS; r++) {
            System.arraycopy(chosen[r], 0, map[r], 0, COLS);
        }
    }

    private void spawnFood() {
        Point p;
        do {
            int x = rnd.nextInt(COLS - 2) + 1;
            int y = rnd.nextInt(ROWS - 2) + 1;
            p = new Point(x, y);
        } while (snake.contains(p) || map[p.y][p.x] == 1);
        food = p;
    }

    private void setDelay(int d) {
        if (d < minDelay) {
            d = minDelay;
        }
        if (timer != null) {
            timer.setDelay(d);
        }
    }

    // ---------- Levels (simple mazes) ----------
    private void createLevels() {
        // Level 0: empty
        int[][] empty = new int[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            Arrays.fill(empty[r], 0);
        }
        for (int i = 0; i < ROWS; i++) {
            empty[i][0] = 1;
            empty[i][COLS - 1] = 1;
        }
        for (int j = 0; j < COLS; j++) {
            empty[0][j] = 1;
            empty[ROWS - 1][j] = 1;
        }
        levels.add(empty);

        // Level 1: simple vertical walls
        int[][] m1 = new int[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            Arrays.fill(m1[r], 0);
        }
        for (int i = 0; i < ROWS; i++) {
            m1[i][0] = 1;
            m1[i][COLS - 1] = 1;
        }
        for (int j = 0; j < COLS; j++) {
            m1[0][j] = 1;
            m1[ROWS - 1][j] = 1;
        }
        for (int r = 3; r < ROWS - 3; r++) {
            m1[r][COLS / 3] = 1;
        }
        for (int r = 3; r < ROWS - 3; r++) {
            m1[r][COLS * 2 / 3] = 1;
        }
        levels.add(m1);

        // Level 2: maze-ish horizontal strips
        int[][] m2 = new int[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            Arrays.fill(m2[r], 0);
        }
        for (int i = 0; i < ROWS; i++) {
            m2[i][0] = 1;
            m2[i][COLS - 1] = 1;
        }
        for (int j = 0; j < COLS; j++) {
            m2[0][j] = 1;
            m2[ROWS - 1][j] = 1;
        }
        for (int c = 2; c < COLS - 2; c += 2) {
            for (int r = 2; r < ROWS - 2; r++) {
                m2[r][c] = (r % 6 == 0) ? 0 : 1;
            }
        }
        levels.add(m2);

        // You can add more levels here
    }

    // ---------- Paint ----------
    @Override
    protected void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg.create();
        // smoothing
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawBackground(g);
        drawGridAndWalls(g);
        drawFood(g);
        drawSnake(g);
        drawHUD(g);

        if (paused) {
            drawCenteredText(g, "PAUSED", 36, Color.WHITE, GAME_W / 2, GAME_H / 2);
        }
        if (gameOver) {
            drawCenteredText(g, "GAME OVER", 40, Color.WHITE, GAME_W / 2, GAME_H / 2 - 20);
            drawCenteredText(g, "Press N to start new game", 18, Color.LIGHT_GRAY, GAME_W / 2, GAME_H / 2 + 20);
        }
        g.dispose();
    }

    private void drawBackground(Graphics2D g) {
        // modern gradient background for game area
        GradientPaint gp = new GradientPaint(0, 0, new Color(10, 10, 12), 0, GAME_H,
                theme == Theme.NEON ? new Color(5, 5, 20) : new Color(18, 18, 20));
        g.setPaint(gp);
        g.fillRect(0, 0, GAME_W, GAME_H);
    }

    private void drawGridAndWalls(Graphics2D g) {
        // subtle grid lines
        g.setColor(new Color(25, 25, 30));
        for (int i = 0; i <= COLS; i++) {
            g.drawLine(i * TILE, 0, i * TILE, GAME_H);
        }
        for (int i = 0; i <= ROWS; i++) {
            g.drawLine(0, i * TILE, GAME_W, i * TILE);
        }

        // draw walls based on map
        g.setColor(new Color(70, 70, 75));
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (map[r][c] == 1) {
                    RoundRectangle2D rr = new RoundRectangle2D.Double(c * TILE + 2, r * TILE + 2, TILE - 4, TILE - 4, 8,
                            8);
                    g.fill(rr);
                }
            }
        }
    }

    private void drawFood(Graphics2D g) {
        if (food == null) {
            return;
        }
        Color fc = theme == Theme.NEON ? new Color(255, 80, 120) : new Color(220, 50, 50);
        g.setColor(fc);
        g.fillOval(food.x * TILE + 6, food.y * TILE + 6, TILE - 12, TILE - 12);
    }

    private void drawSnake(Graphics2D g) {
        for (int i = 0; i < snake.size(); i++) {
            Point p = snake.get(i);
            if (i == 0) {
                g.setColor(theme == Theme.NEON ? new Color(120, 255, 200) : new Color(30, 200, 60));
                g.fill(new RoundRectangle2D.Double(p.x * TILE + 2, p.y * TILE + 2, TILE - 4, TILE - 4, 10, 10));
                // eye
                g.setColor(Color.WHITE);
                int ex = p.x * TILE + (dir == 'L' ? 6 : (dir == 'R' ? TILE - 10 : TILE / 2 - 2));
                int ey = p.y * TILE + (dir == 'U' ? 6 : (dir == 'D' ? TILE - 10 : TILE / 2 - 2));
                g.fillOval(ex, ey, 4, 4);
            } else {
                float t = 0.3f + (float) i / snake.size() * 0.7f;
                Color c;
                if (theme == Theme.NEON) {
                    c = new Color((int) (50 + 200 * t), (int) (30 + 200 * (1 - t)), 180);
                } else {
                    c = new Color((int) (20 + 60 * t), (int) (120 + 50 * (1 - t)), (int) (20 + 60 * (1 - t)));
                }
                g.setColor(c);
                g.fillRect(p.x * TILE + 3, p.y * TILE + 3, TILE - 6, TILE - 6);
            }
        }
        // shield overlay if active
        if (shieldActive) {
            Point head = snake.getFirst();
            g.setColor(new Color(100, 180, 255, 90));
            g.fillOval(head.x * TILE - TILE / 2, head.y * TILE - TILE / 2, TILE * 2, TILE * 2);
        }
    }

    private void drawHUD(Graphics2D g) {
        int x = GAME_W + 10;
        g.setColor(new Color(18, 18, 22));
        g.fillRoundRect(x, 10, HUD_W - 20, GAME_H - 20, 12, 12);

        g.setColor(Color.WHITE);
        g.setFont(hudFont);
        g.drawString("Score: " + score, x + 18, 40);
        g.drawString("Level: " + (levelIndex + 1), x + 18, 70);
        g.drawString("Size: " + snake.size(), x + 18, 100);
        g.drawString("Speed: " + (200 - timer.getDelay()), x + 18, 130);

        // powerups
        g.drawString("Power-ups:", x + 18, 170);
        int yy = 200;
        g.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        g.drawString("Shield: " + (shieldActive ? "ON" : "OFF"), x + 18, yy);
        g.drawString("Boost: " + (boostEndTime > System.currentTimeMillis() ? "ON" : "OFF"), x + 18, yy + 22);
        g.drawString("Slow: " + (slowEndTime > System.currentTimeMillis() ? "ON" : "OFF"), x + 18, yy + 44);

        // theme controls
        g.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        g.drawString("Theme: " + theme.name(), x + 18, yy + 90);
        g.drawString("Press T to cycle themes", x + 18, yy + 110);

        g.drawString("P Pause    R Restart", x + 18, GAME_H - 40);
    }

    private void drawCenteredText(Graphics2D g, String text, int size, Color color, int cx, int cy) {
        g.setColor(new Color(0, 0, 0, 170));
        g.fillRoundRect(cx - 150, cy - 40, 300, 80, 16, 16);
        g.setColor(color);
        g.setFont(new Font("Segoe UI", Font.BOLD, size));
        FontMetrics fm = g.getFontMetrics();
        int w = fm.stringWidth(text);
        g.drawString(text, cx - w / 2, cy + fm.getAscent() / 2 - 6);
    }

    // ---------- Game loop ----------
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!running) {
            return;
        }

        // handle powerup timed effects
        long now = System.currentTimeMillis();
        if (shieldActive && now > shieldEndTime) {
            shieldActive = false;
        }
        if (slowEndTime > 0 && now > slowEndTime) {
            slowEndTime = 0;
            setDelay(baseDelay);
        }
        if (boostEndTime > 0 && now > boostEndTime) {
            boostEndTime = 0;
            setDelay(baseDelay);
        }

        if (!paused && !gameOver) {
            move();
        }
        repaint();
    }

    private void move() {
        Point head = snake.getFirst();
        Point next = new Point(head.x, head.y);

        switch (dir) {
            case 'U' -> next.y--;
            case 'D' -> next.y++;
            case 'L' -> next.x--;
            case 'R' -> next.x++;
        }

        // collisions: walls map==1 or border
        if (next.x < 0 || next.x >= COLS || next.y < 0 || next.y >= ROWS || map[next.y][next.x] == 1) {
            if (shieldActive) {
                // consume shield
                shieldActive = false;
            } else {
                die();
                return;
            }
        }

        // self collision
        if (snake.contains(next)) {
            if (shieldActive) {
                shieldActive = false;
            } else {
                die();
                return;
            }
        }

        // move head
        snake.addFirst(next);

        // eat food
        if (next.equals(food)) {
            score++;
            playOnce("/snakefull/resources/eat.wav");
            spawnFood();
            // small speed up
            int nd = Math.max(minDelay, timer.getDelay() - 4);
            setDelay(nd);

            // randomly spawn powerup effect occasionally
            if (rnd.nextDouble() < 0.18) {
                applyRandomPowerup();
            }
        } else {
            // normal move: remove tail
            snake.removeLast();
        }
    }

    private void applyRandomPowerup() {
        double r = rnd.nextDouble();
        if (r < 0.4) { // shield
            shieldActive = true;
            shieldEndTime = System.currentTimeMillis() + 5000;
            playOnce("/snakefull/resources/boost.wav");
        } else if (r < 0.75) { // slow time (makes game slower)
            slowEndTime = System.currentTimeMillis() + 6000;
            setDelay(timer.getDelay() + 60);
            playOnce("/snakefull/resources/boost.wav");
        } else { // speed boost
            boostEndTime = System.currentTimeMillis() + 3500;
            setDelay(Math.max(minDelay, timer.getDelay() - 50));
            playOnce("/snakefull/resources/boost.wav");
        }
    }

    private void die() {
        gameOver = true;
        running = false;
        timer.stop();
        playOnce("/snakefull/resources/gameover.wav");
        saveScoreToLeaderboard(score);
    }

    // ---------- Leaderboard ----------
    private void loadLeaderboard() {
        try {
            if (!Files.exists(leaderboardFile)) {
                Files.write(leaderboardFile, Arrays.asList("0"), StandardOpenOption.CREATE);
            }
        } catch (IOException ignored) {
        }
    }

    private void saveScoreToLeaderboard(int sc) {
        try {
            List<Integer> scores = new ArrayList<>();
            if (Files.exists(leaderboardFile)) {
                List<String> lines = Files.readAllLines(leaderboardFile);
                for (String ln : lines) {
                    try {
                        scores.add(Integer.parseInt(ln.trim()));
                    } catch (Exception ex) {
                    }
                }
            }
            scores.add(sc);
            scores.sort(Comparator.reverseOrder());
            if (scores.size() > LEADERBOARD_SIZE) {
                scores = scores.subList(0, LEADERBOARD_SIZE);
            }
            List<String> out = new ArrayList<>();
            for (Integer i : scores) {
                out.add(i.toString());
            }
            Files.write(leaderboardFile, out, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<Integer> readLeaderboard() {
        try {
            if (Files.exists(leaderboardFile)) {
                List<String> lines = Files.readAllLines(leaderboardFile);
                List<Integer> res = new ArrayList<>();
                for (String s : lines) {
                    try {
                        res.add(Integer.parseInt(s.trim()));
                    } catch (Exception ignored) {
                    }
                }
                return res;
            }
        } catch (IOException ignored) {
        }
        return Collections.emptyList();
    }

    // ---------- Input ----------
    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        if (!gameOver && !paused) {
            if ((k == KeyEvent.VK_W || k == KeyEvent.VK_UP) && dir != 'D') {
                dir = 'U';
            }
            if ((k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) && dir != 'U') {
                dir = 'D';
            }
            if ((k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) && dir != 'R') {
                dir = 'L';
            }
            if ((k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) && dir != 'L') {
                dir = 'R';
            }
        }
        if (k == KeyEvent.VK_P) {
            togglePause();
        }
        if (k == KeyEvent.VK_R) {
            initGame();
            timer.start();
        }
        if (k == KeyEvent.VK_N && gameOver) {
            initGame();
            timer.start();
        }
        if (k == KeyEvent.VK_T) {
            cycleTheme();
        }
        if (k == KeyEvent.VK_1) {
            setLevel(0);
        }
        if (k == KeyEvent.VK_2) {
            setLevel(1);
        }
        if (k == KeyEvent.VK_3) {
            setLevel(2);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // ---------- Theme / options ----------
    private void cycleTheme() {
        if (theme == Theme.MODERN) {
            theme = Theme.NEON;
        } else if (theme == Theme.NEON) {
            theme = Theme.RETRO;
        } else {
            theme = Theme.MODERN;
        }
    }

    // ---------- Sound helpers ----------
    private void playOnce(String resourcePath) {
        try (InputStream is = getClass().getResourceAsStream(resourcePath)) {
            if (is == null) {
                return;
            }
            try (BufferedInputStream bis = new BufferedInputStream(is)) {
                AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
            }
        } catch (Exception ignored) {
        }
    }

    private void playLoop(String resourcePath) {
        // start background music loop (non-blocking). Silently ignore if file missing.
        try (InputStream is = getClass().getResourceAsStream(resourcePath)) {
            if (is == null) {
                return;
            }
            BufferedInputStream bis = new BufferedInputStream(is);
            AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
            musicClip = AudioSystem.getClip();
            musicClip.open(ais);
            FloatControl gain = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gain.setValue(-12.0f); // reduce volume
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ignored) {
        }
    }

    // ---------- Utilities ----------
    private void togglePause() {
        paused = !paused;
        if (paused) {
            timer.stop();
        } else {
            timer.start();
        }
        repaint();
    }

    // ---------- UI / main ----------
    private static void createAndShowGUI() {
        JFrame f = new JFrame("Snake Deluxe - Modern");
        SnakeDeluxe g = new SnakeDeluxe(f);

        // menu
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Game");
        JMenuItem newG = new JMenuItem("New");
        newG.addActionListener(a -> {
            g.initGame();
            g.timer.start();
            g.requestFocusInWindow();
        });
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(a -> System.exit(0));
        JMenuItem leaderboard = new JMenuItem("Leaderboard");
        leaderboard.addActionListener(a -> {
            List<Integer> top = g.readLeaderboard();
            StringBuilder sb = new StringBuilder();
            int idx = 1;
            for (Integer sc : top) {
                sb.append(idx++).append(". ").append(sc).append("\n");
            }
            if (sb.length() == 0) {
                sb.append("No scores yet.");
            }
            JOptionPane.showMessageDialog(f, sb.toString(), "Leaderboard", JOptionPane.INFORMATION_MESSAGE);
        });
        menu.add(newG);
        menu.add(leaderboard);
        menu.addSeparator();
        menu.add(exit);
        mb.add(menu);
        f.setJMenuBar(mb);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(g);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        // optional icon
        try {
            InputStream is = SnakeDeluxe.class.getResourceAsStream("/snakefull/resources/icon.png");
            if (is != null) {
                f.setIconImage(Toolkit.getDefaultToolkit().createImage(is.readAllBytes()));
            }
        } catch (Exception ignored) {
        }

        f.setVisible(true);
        g.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnakeDeluxe::createAndShowGUI);
    }
}
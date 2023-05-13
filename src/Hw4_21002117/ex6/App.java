package Hw4_21002117.ex6;

import java.awt.Color;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class App extends javax.swing.JFrame implements Runnable {

        public App() {
                guestQueue = new LinkedList<>();
                timeMap = new HashMap<>();
                currentNumber = 1;
                numberOfGuest = 0;
                timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss a");
                timeStr = LocalDateTime.now().format(timeFormat);
                startTimes = new LocalDateTime[5];
                guestIDs = new int[5];
                initComponents();
                Thread thread = new Thread(this);
                thread.start();
        }

        private void initComponents() {

                jScrollPane1 = new JScrollPane();
                jEditorPane1 = new JEditorPane();
                jPanel1 = new JPanel();
                JLabel timeText = new JLabel();
                time = new JLabel();
                JLabel guestText = new JLabel();
                guestCount = new JLabel();
                JLabel deskNo1Text = new JLabel();
                JLabel deskNo2Text = new JLabel();
                JLabel deskNo3Text = new JLabel();
                JLabel deskNo4Text = new JLabel();
                JLabel deskNo5Text = new JLabel();
                deskNo1End = new JButton();
                deskNo2End = new JButton();
                deskNo3End = new JButton();
                deskNo4End = new JButton();
                deskNo5End = new JButton();
                deskNo1Status = new JLabel();
                deskNo2Status = new JLabel();
                deskNo3Status = new JLabel();
                deskNo4Status = new JLabel();
                deskNo5Status = new JLabel();
                addGuest = new JButton();
                jPanel2 = new JPanel();
                JLabel historyText = new JLabel();
                scroll = new JScrollPane();
                table = new JTable();
                JLabel totalText = new JLabel();
                totalCount = new JLabel();

                jScrollPane1.setViewportView(jEditorPane1);

                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setTitle("Giả lập hệ thống điều hành phục vụ khách hàng by LĐA");

                timeText.setText("Thời gian hiện tại:");

                time.setFont(new java.awt.Font("Segoe UI", 1, 18));
                time.setText(timeStr);
                time.setForeground(Color.GREEN);
                time.setOpaque(true);
                time.setBackground(Color.BLACK);
                time.setHorizontalAlignment(JLabel.CENTER);

                guestText.setText("Số khách đang chờ:");

                guestCount.setText("0");

                deskNo1Text.setText("Quầy 1: ");

                deskNo2Text.setText("Quầy 2: ");

                deskNo3Text.setText("Quầy 3: ");

                deskNo4Text.setText("Quầy 4: ");

                deskNo5Text.setText("Quầy 5: ");

                deskNo1End.setText("Kết thúc giao dịch");
                deskNo1End.setEnabled(false);
                deskNo1End.addActionListener(this::deskNo1EndActionPerformed);

                deskNo2End.setText("Kết thúc giao dịch");
                deskNo2End.setEnabled(false);
                deskNo2End.addActionListener(this::deskNo2EndActionPerformed);

                deskNo3End.setText("Kết thúc giao dịch");
                deskNo3End.setEnabled(false);
                deskNo3End.addActionListener(this::deskNo3EndActionPerformed);

                deskNo4End.setText("Kết thúc giao dịch");
                deskNo4End.setEnabled(false);
                deskNo4End.addActionListener(this::deskNo4EndActionPerformed);

                deskNo5End.setText("Kết thúc giao dịch");
                deskNo5End.setEnabled(false);
                deskNo5End.addActionListener(this::deskNo5EndActionPerformed);

                deskNo1Status.setForeground(new java.awt.Color(0, 153, 0));
                deskNo1Status.setText("Bàn trống!");

                deskNo2Status.setForeground(new java.awt.Color(0, 153, 0));
                deskNo2Status.setText("Bàn trống!");

                deskNo3Status.setForeground(new java.awt.Color(0, 153, 0));
                deskNo3Status.setText("Bàn trống!");

                deskNo4Status.setForeground(new java.awt.Color(0, 153, 0));
                deskNo4Status.setText("Bàn trống!");

                deskNo5Status.setForeground(new java.awt.Color(0, 153, 0));
                deskNo5Status.setText("Bàn trống!");

                addGuest.setText("Khách đến nhận số");
                addGuest.addActionListener(this::addGuestActionPerformed);

                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(6, 6, 6)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(deskNo1Text)
                                                                                                                                .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(deskNo1End)
                                                                                                                                .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(deskNo1Status,
                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE))
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(guestText,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                117,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addComponent(deskNo2Text)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(deskNo2End)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(deskNo2Status))
                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addComponent(deskNo3Text)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(deskNo3End)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(deskNo3Status))
                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addComponent(deskNo4Text)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(deskNo4End)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(deskNo4Status))
                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addComponent(deskNo5Text)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(deskNo5End)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(deskNo5Status)))
                                                                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(timeText,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                107,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(guestCount,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                48,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(addGuest)
                                                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                                                .addComponent(time,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))))
                                                                .addContainerGap()));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(timeText)
                                                                                .addComponent(time))
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(guestText)
                                                                                .addComponent(guestCount)
                                                                                .addComponent(addGuest))
                                                                .addGap(43, 43, 43)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(deskNo1Text)
                                                                                .addComponent(deskNo1Status)
                                                                                .addComponent(deskNo1End))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(deskNo2Text)
                                                                                .addComponent(deskNo2End)
                                                                                .addComponent(deskNo2Status))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(deskNo3Text)
                                                                                .addComponent(deskNo3End)
                                                                                .addComponent(deskNo3Status))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(deskNo4Text)
                                                                                .addComponent(deskNo4End)
                                                                                .addComponent(deskNo4Status))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(deskNo5Text)
                                                                                .addComponent(deskNo5End)
                                                                                .addComponent(deskNo5Status))
                                                                .addGap(0, 0, Short.MAX_VALUE)));

                historyText.setHorizontalAlignment(SwingConstants.CENTER);
                historyText.setText("Lịch sử giao dịch");

                table.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "ID khách hàng", "Đến", "Bắt đầu", "Kết thúc",
                                                "Tổng (giây)"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.String.class, java.lang.Double.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });

                model = (DefaultTableModel) table.getModel();

                scroll.setViewportView(table);

                totalText.setText("Tổng số khách đã phục vụ: ");

                totalCount.setText("0");

                GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(scroll)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(historyText,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                483, Short.MAX_VALUE)
                                                                                .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(totalText)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(totalCount)
                                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(historyText)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(scroll,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                398,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(totalText)
                                                                                .addComponent(totalCount))
                                                                .addContainerGap(13, Short.MAX_VALUE)));

                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel1,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jPanel2,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPanel2,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jPanel1,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));

                pack();
        }

        private void deskNo1EndActionPerformed(java.awt.event.ActionEvent evt) {
                LocalDateTime now = LocalDateTime.now();
                duration = Duration.between(startTimes[0], now);
                model.addRow(new Object[] { guestIDs[0], timeMap.remove(guestIDs[0]), startTimes[0].format(timeFormat),
                                now.format(timeFormat), duration.toMillis() / 1000.0 });
                deskNo1End.setEnabled(false);
                deskNo1Status.setText("Bàn trống!");
                deskNo1Status.setForeground(new Color(0, 153, 0));
                totalCount.setText(Integer.toString(table.getRowCount()));
        }

        private void deskNo2EndActionPerformed(java.awt.event.ActionEvent evt) {
                LocalDateTime now = LocalDateTime.now();
                duration = Duration.between(startTimes[1], now);
                model.addRow(new Object[] { guestIDs[1], timeMap.remove(guestIDs[1]), startTimes[1].format(timeFormat),
                                now.format(timeFormat), duration.toMillis() / 1000.0 });
                deskNo2End.setEnabled(false);
                deskNo2Status.setText("Bàn trống!");
                deskNo2Status.setForeground(new Color(0, 153, 0));
                totalCount.setText(Integer.toString(table.getRowCount()));
        }

        private void deskNo3EndActionPerformed(java.awt.event.ActionEvent evt) {
                LocalDateTime now = LocalDateTime.now();
                duration = Duration.between(startTimes[2], now);
                model.addRow(new Object[] { guestIDs[2], timeMap.remove(guestIDs[2]), startTimes[2].format(timeFormat),
                                now.format(timeFormat), duration.toMillis() / 1000.0 });
                deskNo3End.setEnabled(false);
                deskNo3Status.setText("Bàn trống!");
                deskNo3Status.setForeground(new Color(0, 153, 0));
                totalCount.setText(Integer.toString(table.getRowCount()));
        }

        private void deskNo4EndActionPerformed(java.awt.event.ActionEvent evt) {
                LocalDateTime now = LocalDateTime.now();
                duration = Duration.between(startTimes[3], now);
                model.addRow(new Object[] { guestIDs[3], timeMap.remove(guestIDs[3]), startTimes[3].format(timeFormat),
                                now.format(timeFormat), duration.toMillis() / 1000.0 });
                deskNo4End.setEnabled(false);
                deskNo4Status.setText("Bàn trống!");
                deskNo4Status.setForeground(new Color(0, 153, 0));
                totalCount.setText(Integer.toString(table.getRowCount()));
        }

        private void deskNo5EndActionPerformed(java.awt.event.ActionEvent evt) {
                LocalDateTime now = LocalDateTime.now();
                duration = Duration.between(startTimes[4], now);
                model.addRow(new Object[] { guestIDs[4], timeMap.remove(guestIDs[4]), startTimes[4].format(timeFormat),
                                now.format(timeFormat), duration.toMillis() / 1000.0 });
                deskNo5End.setEnabled(false);
                deskNo5Status.setText("Bàn trống!");
                deskNo5Status.setForeground(new Color(0, 153, 0));
                totalCount.setText(Integer.toString(table.getRowCount()));
        }

        @Override
        public void run() {
                while (true) {
                        timeStr = LocalDateTime.now().format(timeFormat);
                        time.setText(timeStr);
                        if (deskNo1Status.getText().equals("Bàn trống!") && !guestQueue.isEmpty()
                                        && numberOfGuest != 0) {
                                deskNo1Status.setText("Có khách!");
                                deskNo1Status.setForeground(Color.RED);
                                guestCount.setText(Integer.toString(--numberOfGuest));
                                deskNo1End.setEnabled(true);
                                startTimes[0] = LocalDateTime.now();
                                guestIDs[0] = guestQueue.poll();
                        }
                        if (deskNo2Status.getText().equals("Bàn trống!") && !guestQueue.isEmpty()
                                        && numberOfGuest != 0) {
                                deskNo2Status.setText("Có khách!");
                                deskNo2Status.setForeground(Color.RED);
                                guestCount.setText(Integer.toString(--numberOfGuest));
                                deskNo2End.setEnabled(true);
                                startTimes[1] = LocalDateTime.now();
                                guestIDs[1] = guestQueue.poll();
                        }
                        if (deskNo3Status.getText().equals("Bàn trống!") && !guestQueue.isEmpty()
                                        && numberOfGuest != 0) {
                                deskNo3Status.setText("Có khách!");
                                deskNo3Status.setForeground(Color.RED);
                                guestCount.setText(Integer.toString(--numberOfGuest));
                                deskNo3End.setEnabled(true);
                                startTimes[2] = LocalDateTime.now();
                                guestIDs[2] = guestQueue.poll();
                        }
                        if (deskNo4Status.getText().equals("Bàn trống!") && !guestQueue.isEmpty()
                                        && numberOfGuest != 0) {
                                deskNo4Status.setText("Có khách!");
                                deskNo4Status.setForeground(Color.RED);
                                guestCount.setText(Integer.toString(--numberOfGuest));
                                deskNo4End.setEnabled(true);
                                startTimes[3] = LocalDateTime.now();
                                guestIDs[3] = guestQueue.poll();
                        }
                        if (deskNo5Status.getText().equals("Bàn trống!") && !guestQueue.isEmpty()
                                        && numberOfGuest != 0) {
                                deskNo5Status.setText("Có khách!");
                                deskNo5Status.setForeground(Color.RED);
                                guestCount.setText(Integer.toString(--numberOfGuest));
                                deskNo5End.setEnabled(true);
                                startTimes[4] = LocalDateTime.now();
                                guestIDs[4] = guestQueue.poll();
                        }
                        try {
                                Thread.sleep(1000);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
        }

        private void addGuestActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addGuestActionPerformed
                guestQueue.add(currentNumber);
                timeMap.put(currentNumber, LocalDateTime.now().format(timeFormat));
                currentNumber++;
                guestCount.setText(Integer.toString(++numberOfGuest));
        }

        public static void main(String args[]) {
                try {

                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception e) {
                        System.out.println("Look and Feel not set");
                }

                new App().setVisible(true);
        }

        private JButton addGuest;
        private JButton deskNo1End;
        private JLabel deskNo1Status;
        private JButton deskNo2End;
        private JLabel deskNo2Status;
        private JButton deskNo3End;
        private JLabel deskNo3Status;
        private JButton deskNo4End;
        private JLabel deskNo4Status;
        private JButton deskNo5End;
        private JLabel deskNo5Status;
        private JLabel guestCount;
        private JEditorPane jEditorPane1;
        private JPanel jPanel1;
        private JPanel jPanel2;
        private JScrollPane jScrollPane1;
        private JScrollPane scroll;
        private JTable table;
        private DefaultTableModel model;
        private JLabel time;
        private JLabel totalCount;
        private Queue<Integer> guestQueue;
        private Map<Integer, String> timeMap;
        private int currentNumber;
        private int numberOfGuest;
        private DateTimeFormatter timeFormat;
        private String timeStr;
        private LocalDateTime[] startTimes;
        private int[] guestIDs;
        private Duration duration;
}

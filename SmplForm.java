//create a form using layout manager in java?

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SmplForm implements Runnable {

    @Override // java.lang.Runnable
    public void run() {
        createAndDisplayGui();
    }

    private void createAndDisplayGui() {
        JFrame frame = new JFrame("Nonce creator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(createForm(), BorderLayout.CENTER);
        frame.add(createButtonsPanel(), BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        JButton proceedButton = new JButton("Proceed");
        buttonsPanel.add(proceedButton);
        return buttonsPanel;
    }

    private JPanel createForm() {
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;
        gbc.insets.top = 5;

        JLabel transactionLabel = new JLabel("Transaction");
        form.add(transactionLabel, gbc);
        gbc.gridx = 1;
        JTextField transactionTextField = new JTextField(20);
        form.add(transactionTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel nonceLabel = new JLabel("Nonce");
        form.add(nonceLabel, gbc);
        gbc.gridx = 1;
        JTextField nonceTextField = new JTextField(20);
        form.add(nonceTextField, gbc);
        gbc.gridx = 2;
        JCheckBox autoCheckBox = new JCheckBox("Auto");
        form.add(autoCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel hashLabel = new JLabel("Hash");
        form.add(hashLabel, gbc);
        gbc.gridx = 1;
        JTextField hashTextField = new JTextField(20);
        hashTextField.setText("8350e5a3e24c153df2275c9f80692773");
        hashTextField.setEnabled(false);
        form.add(hashTextField, gbc);

        return form;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new SmplForm());
    }
}



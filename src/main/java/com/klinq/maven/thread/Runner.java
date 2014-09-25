package com.klinq.maven.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Run a command on shell and output data in textfield
 * 
 * @author Deisss
 */
public class Runner implements Runnable {
    protected final JTextArea textarea;
    protected final String cmd;

    public Runner(JTextArea textArea, String cmd) {
        this.textarea = textArea;
        this.cmd = cmd;
    }

    private void appendText(String text) {
        this.textarea.setText(this.textarea.getText() + text);
    }

    private void appendLine(String line) {
        this.appendText(line + "\r\n");
    }

    public void run() {
        try {
            this.textarea.setText("");

            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/k", this.cmd);
            pb.redirectErrorStream(true);

            Process child = pb.start();

            InputStreamReader r = new InputStreamReader(child.getInputStream());
            BufferedReader in = new BufferedReader(r);

            String line;
            while ((line = in.readLine()) != null) {
                // Appending data
                this.appendLine(line);
            }
            in.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error while reading output: "+
                    ex.getCause(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

/*
 * $Id$
 *
 * Copyright (c) 1998-2008 John Morrison.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */


/*
 * GameFinder.java
 *
 * Created on 21 May 2004, 23:39
 */

package com.jbolo.gui.dialog.gamefinder;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.ListIterator;
import com.jbolo.bolo.Utils;
import com.jbolo.gui.BoloPreferences;
import com.jbolo.gui.dialog.MessageBox;
import com.jbolo.gui.dialog.CentredDialog;
import com.jbolo.gui.dialog.SetPlayerNameDialog;
import com.jbolo.gui.dialog.TrackerSetupDialog;

/**
 *
 * @author  John Morrrison
 */
public class GameFinderDialog extends CentredDialog {
    
    /**
	 * Serial UID
	 */
	private static final long serialVersionUID = 5574630740511204321L;

	private static String EMPTY_STRING = "";
    
    /** Our lookup connection */
    private GameFinderConnection con;
    
    /** Type of connection */
    boolean lanFinder;
    
    /** The currently selected game */
    private CurrentGame selectedGame;
    
    
    /** Creates new form GameFinder */
    public GameFinderDialog(java.awt.Frame parent, boolean modal, boolean lanFinder) {
        super(parent, "Game Finder", modal);
        initComponents();
        setSize(480, 500);
        centre();
        this.lanFinder = lanFinder;
        bMOTD.setEnabled(false);
        if (lanFinder == true) {
            con = new LanBroadcastFinderConnection();
            setTitle("LAN Game Finder");
        } else {
            con = new TrackerFinderConnection();
            setTitle("Tracker Game Finder");
        }
        clearDisplay();
        
    }
    
    /**
     * Clears all the current game entries
     */
    private void clearDisplay() {
        lblAddress.setText(EMPTY_STRING);
        lblAddress1.setText("asdfsdf");
        lblBases.setText(EMPTY_STRING);
        lblBrains.setText(EMPTY_STRING);
        lblGameType.setText(EMPTY_STRING);
        lblMapName.setText(EMPTY_STRING);
        lblMines.setText(EMPTY_STRING);
        lblNoPlayers.setText(EMPTY_STRING);
        lblPassword.setText(EMPTY_STRING);
        lblPillboxes.setText(EMPTY_STRING);
        lblPort.setText(EMPTY_STRING);
        lblVersion.setText(EMPTY_STRING);
    }
    
    private String getGameTypeString(int value) {
        if (value == 0) {
            return "Open";
        } else if (value == 1) {
            return "Tournament";
        } else {
            return "Strict Tournament";
        }
    }
    
    private String getBrainsString(int value) {
        if (value == 0) {
            return "No";
        } else if (value == 1) {
            return "Yes";
        } 
        return "Yes (Advantage)";
    }
    
    
    /** This method is called from within the constructor to
     * initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.Button bJoinAddress;
        java.awt.Button bTrackerSetup;
        java.awt.Button button1;
        java.awt.Button button2;
        java.awt.Button button3;
        java.awt.Button button4;
        java.awt.Label label1;
        java.awt.Label label10;
        java.awt.Label label11;
        java.awt.Label label12;
        java.awt.Label label13;
        java.awt.Label label2;
        java.awt.Label label3;
        java.awt.Label label4;
        java.awt.Label label5;
        java.awt.Label label6;
        java.awt.Label label7;
        java.awt.Label label8;
        java.awt.Label label9;

        lblAddress1 = new java.awt.Label();
        listGames = new java.awt.List();
        bTrackerSetup = new java.awt.Button();
        button2 = new java.awt.Button();
        bMOTD = new java.awt.Button();
        bJoinAddress = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        bJoin = new java.awt.Button();
        bRejoin = new java.awt.Button();
        button1 = new java.awt.Button();
        label1 = new java.awt.Label();
        lblStatus = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        label9 = new java.awt.Label();
        label10 = new java.awt.Label();
        label11 = new java.awt.Label();
        label12 = new java.awt.Label();
        label13 = new java.awt.Label();
        lblAddress = new java.awt.Label();
        lblMapName = new java.awt.Label();
        lblNoPlayers = new java.awt.Label();
        lblGameType = new java.awt.Label();
        lblBases = new java.awt.Label();
        lblPillboxes = new java.awt.Label();
        lblMines = new java.awt.Label();
        lblPassword = new java.awt.Label();
        lblBrains = new java.awt.Label();
        lblPort = new java.awt.Label();
        lblVersion = new java.awt.Label();

        setLayout(null);

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        listGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listGamesActionPerformed(evt);
            }
        });
        listGames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listGamesItemStateChanged(evt);
            }
        });

        add(listGames);
        listGames.setBounds(10, 50, 200, 210);

        bTrackerSetup.setLabel("Tracker Setup");
        bTrackerSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTrackerSetupActionPerformed(evt);
            }
        });

        add(bTrackerSetup);
        bTrackerSetup.setBounds(10, 370, 120, 24);

        button2.setLabel("Set Player Name");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        add(button2);
        button2.setBounds(10, 410, 120, 24);

        bMOTD.setLabel("Message of the Day");
        bMOTD.setName("bMOTD");
        bMOTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMOTDActionPerformed(evt);
            }
        });

        add(bMOTD);
        bMOTD.setBounds(10, 450, 120, 24);

        bJoinAddress.setLabel("Join By Address");
        add(bJoinAddress);
        bJoinAddress.setBounds(250, 370, 100, 24);

        button3.setLabel("Refresh");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        add(button3);
        button3.setBounds(250, 410, 100, 24);

        button4.setLabel("New");
        add(button4);
        button4.setBounds(250, 450, 100, 24);

        bJoin.setEnabled(false);
        bJoin.setLabel("Join");
        add(bJoin);
        bJoin.setBounds(380, 370, 60, 24);

        bRejoin.setEnabled(false);
        bRejoin.setLabel("Rejoin");
        add(bRejoin);
        bRejoin.setBounds(380, 410, 60, 24);

        button1.setLabel("Cancel");
        add(button1);
        button1.setBounds(380, 450, 60, 24);

        label1.setText("Status:");
        add(label1);
        label1.setBounds(200, 310, 40, 20);

        lblStatus.setText("Idle");
        add(lblStatus);
        lblStatus.setBounds(240, 310, 240, 20);

        label2.setText("Selected Game Information");
        add(label2);
        label2.setBounds(220, 50, 170, 20);

        label3.setAlignment(java.awt.Label.RIGHT);
        label3.setText("Server Address: ");
        add(label3);
        label3.setBounds(220, 80, 110, 20);

        label4.setAlignment(java.awt.Label.RIGHT);
        label4.setText("Server Port: ");
        add(label4);
        label4.setBounds(220, 100, 110, 20);

        label5.setAlignment(java.awt.Label.RIGHT);
        label5.setText("Version: ");
        add(label5);
        label5.setBounds(380, 100, 60, 20);

        label6.setAlignment(java.awt.Label.RIGHT);
        label6.setText("Map Name: ");
        add(label6);
        label6.setBounds(220, 120, 110, 20);

        label7.setAlignment(java.awt.Label.RIGHT);
        label7.setText("Number of Players: ");
        add(label7);
        label7.setBounds(220, 140, 110, 20);

        label8.setAlignment(java.awt.Label.RIGHT);
        label8.setText("Game Type: ");
        add(label8);
        label8.setBounds(220, 160, 110, 20);

        label9.setAlignment(java.awt.Label.RIGHT);
        label9.setText("No Free Bases: ");
        add(label9);
        label9.setBounds(220, 180, 110, 20);

        label10.setAlignment(java.awt.Label.RIGHT);
        label10.setText("No Free Pillboxes: ");
        add(label10);
        label10.setBounds(220, 200, 110, 20);

        label11.setAlignment(java.awt.Label.RIGHT);
        label11.setText("Hidden Mines: ");
        add(label11);
        label11.setBounds(220, 220, 110, 20);

        label12.setAlignment(java.awt.Label.RIGHT);
        label12.setText("Password: ");
        add(label12);
        label12.setBounds(220, 240, 110, 20);

        label13.setAlignment(java.awt.Label.RIGHT);
        label13.setText("Brains: ");
        add(label13);
        label13.setBounds(220, 260, 110, 20);

        add(lblAddress);
        lblAddress.setBounds(330, 80, 150, 20);

        add(lblMapName);
        lblMapName.setBounds(330, 120, 150, 20);

        add(lblNoPlayers);
        lblNoPlayers.setBounds(330, 140, 150, 20);

        add(lblGameType);
        lblGameType.setBounds(330, 160, 150, 20);

        add(lblBases);
        lblBases.setBounds(330, 180, 150, 20);

        add(lblPillboxes);
        lblPillboxes.setBounds(330, 200, 150, 20);

        add(lblMines);
        lblMines.setBounds(330, 220, 150, 20);

        add(lblPassword);
        lblPassword.setBounds(330, 240, 150, 20);

        add(lblBrains);
        lblBrains.setBounds(330, 260, 150, 20);

        add(lblPort);
        lblPort.setBounds(330, 100, 50, 20);

        add(lblVersion);
        lblVersion.setBounds(440, 100, 50, 20);

        pack();
    }//GEN-END:initComponents

    private void listGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listGamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listGamesActionPerformed
    
    private void listGamesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listGamesItemStateChanged
        // TODO add your handling code here:
        String s;
        CurrentGame cg;
        ListIterator<CurrentGame> li;
        boolean found = false;
        
        
        s = listGames.getSelectedItem();
        if (s != null) {
            li = con.getList().listIterator();
            while (li.hasNext() && found == false) {
                cg = li.next();
                if (cg.matches(s) == true) {
                    selectedGame = cg;
                    found = true;
                }
            }
        }
        if (found == true) {
            // Set the variables up
            lblAddress.setText(selectedGame.getAddress());
            lblBases.setText(Integer.toString(selectedGame.getNumBases()));
            lblBrains.setText(getBrainsString(selectedGame.getAI()));
            lblGameType.setText(getGameTypeString(selectedGame.getGameType()));
            lblMapName.setText(selectedGame.getMapName());
            lblMines.setText(Utils.ConvertBoolToYesNoTo(selectedGame.allowMines()));
            lblNoPlayers.setText(Integer.toString(selectedGame.getNumPlayers()));
            lblPassword.setText(Utils.ConvertBoolToYesNoTo(selectedGame.hasPassword()));
            lblPillboxes.setText(Integer.toString(selectedGame.getNumPills()));
            lblPort.setText(Integer.toString(selectedGame.getPort()));
            lblVersion.setText(selectedGame.getVersion());
        }
    }//GEN-LAST:event_listGamesItemStateChanged
    
    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        ListIterator<CurrentGame> li;
        CurrentGame cg;
        
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        listGames.removeAll();
        clearDisplay();
        con.searchForGames(lblStatus);
        if (con.getResult() == true) {
            li = con.getList().listIterator();
            while (li.hasNext()) {
                cg = li.next();
                listGames.add(cg.getAddressPort());
            }
            if (lanFinder == false) {
                bMOTD.setEnabled(true);
            }
        } else {
            bMOTD.setEnabled(false);
        }
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_button3ActionPerformed
    
    private void bMOTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMOTDActionPerformed
        // TODO add your handling code here:
        new MessageBox(this, con.getMOTD(), "Message of the day");
    }//GEN-LAST:event_bMOTDActionPerformed
    
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        BoloPreferences bp = BoloPreferences.GetInstance();
        SetPlayerNameDialog pn = new SetPlayerNameDialog(this, false, null, bp.getPrivateProfileString("SETTINGS", "Player Name", "Me"));
        
        if (pn.isNameChanged() == true) {
            bp.writePriveteProfileString("SETTINGS", "Player Name", pn.getName());
        }
        pn = null;
    }//GEN-LAST:event_button2ActionPerformed
    
    private void bTrackerSetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTrackerSetupActionPerformed
        // TODO add your handling code here:
        TrackerSetupDialog ts = new TrackerSetupDialog(this  , true);
        ts.centre();
        ts.setVisible(true);
    }//GEN-LAST:event_bTrackerSetupActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        GameFinderDialog d = new GameFinderDialog(new java.awt.Frame(), true, false);
        d.show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button bJoin;
    private java.awt.Button bMOTD;
    private java.awt.Button bRejoin;
    private java.awt.Label lblAddress;
    private java.awt.Label lblAddress1;
    private java.awt.Label lblBases;
    private java.awt.Label lblBrains;
    private java.awt.Label lblGameType;
    private java.awt.Label lblMapName;
    private java.awt.Label lblMines;
    private java.awt.Label lblNoPlayers;
    private java.awt.Label lblPassword;
    private java.awt.Label lblPillboxes;
    private java.awt.Label lblPort;
    private java.awt.Label lblStatus;
    private java.awt.Label lblVersion;
    private java.awt.List listGames;
    // End of variables declaration//GEN-END:variables
    
}

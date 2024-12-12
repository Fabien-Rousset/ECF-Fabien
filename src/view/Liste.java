package view;

import entities.Client;
import entities.ExoException;
import entities.ListeClient;
import entities.Prospect;
import utilities.SocieteChoix;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

import static entities.ListeClient.listeClient;
import static entities.ListeProspect.listeProspect;
import static utilities.RegexPattern.DATE_FORMATTER;

public class Liste extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable table1;
    private SocieteChoix societeChoix;

    public Liste() {


        getRootPane().setDefaultButton(buttonOK);
        initFrame();
    }


    private void initFrame(){
        setContentPane(contentPane);
        setTitle("Liste");
        setSize(600, 400);
        setVisible(false);
    }

    private void listeners(){



        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void remplissageJTable(){
        String[] entetes;
        DefaultTableModel tableModel;

        if (societeChoix == SocieteChoix.CLIENT){
            setTitle("Liste clients");
            entetes = new String[]{"ID", "Raison Sociale", "téléphone", "email", "commentaire", "adresse", "Chiffre d'affaire", "nb employé" };
            tableModel = new DefaultTableModel(entetes, 0);
            tableModel.addRow(entetes);

            for (Client listeClient : listeClient) {
                if (societeChoix == SocieteChoix.CLIENT){
                    tableModel.addRow(new Object[]{
                            listeClient.getIdSociete(),
                            listeClient.getRaisonSocialeSociete(),
                            listeClient.getTelSociete(),
                            listeClient.getEmailSociete(),
                            listeClient.getCommentaireSociete(),
                            listeClient.getAdresseSociete(),
                            listeClient.getChiffreAffaire(),
                            listeClient.getNbEmploye()

                    });
                }
            }
        } else if (societeChoix == SocieteChoix.PROSPECT) {
            setTitle("Liste prospects");
            entetes = new String[]{"ID", "Raison Sociale", "téléphone", "email", "commentaire", "adresse", "date prospection", "interet"};
            tableModel = new DefaultTableModel(entetes, 0);
            tableModel.addRow(entetes);

            for (Prospect listeProspect : listeProspect) {
                if (societeChoix == SocieteChoix.PROSPECT){
                    tableModel.addRow(new Object[]{
                            listeProspect.getIdSociete(),
                            listeProspect.getRaisonSocialeSociete(),
                            listeProspect.getTelSociete(),
                            listeProspect.getEmailSociete(),
                            listeProspect.getCommentaireSociete(),
                            listeProspect.getAdresseSociete(),
                            listeProspect.getDateProspection().format(DATE_FORMATTER),
                            listeProspect.getInterested()

                    });

                }
            }


        } else {
            throw new IllegalArgumentException("une erreur est survenue ");
        }
    }
}



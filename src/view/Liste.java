package view;

import entities.Client;
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
    private JButton buttonAccueil;
    private JButton buttonQuitter;
    private JTable table1;
    private SocieteChoix societeChoix;

    //Pareil ici, je lui demande dans le constructeur de me donner le choix qu'il a fait
    //Et je le donne a la méthode
    public Liste(SocieteChoix p_societeChoix) {
        getRootPane().setDefaultButton(buttonAccueil);
        initFrame();
        listeners();
        remplissageJTable(p_societeChoix);
    }


    private void initFrame(){
        setContentPane(contentPane);

        setSize(1200, 400);
        setVisible(false);

    }

    private void listeners(){



        buttonAccueil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
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

    //Je lui demande en paramètre le choix qu'il a fait (Client ou Prospect)
    private void remplissageJTable(SocieteChoix p_societeChoix){
        String[] entetes;
        DefaultTableModel tableModel;

        if (p_societeChoix == SocieteChoix.CLIENT){
            setTitle("Liste clients");
            entetes = new String[]{"ID", "Raison Sociale", "téléphone", "email", "commentaire", "adresse", "Chiffre d'affaire", "nb employé" };
            tableModel = new DefaultTableModel(entetes, 0);
            tableModel.addRow(entetes);

            for (Client listeClient : listeClient) {
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
            table1.setModel(tableModel);
        } else if (p_societeChoix == SocieteChoix.PROSPECT) {
            setTitle("Liste prospects");
            entetes = new String[]{"ID", "Raison Sociale", "téléphone", "email", "commentaire", "adresse", "date prospection", "interet"};
            tableModel = new DefaultTableModel(entetes, 0);
            tableModel.addRow(entetes);

            for (Prospect listeProspect : listeProspect) {
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
            table1.setModel(tableModel);
        }
    }
}



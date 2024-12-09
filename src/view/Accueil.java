package view;

import utilities.SocieteChoix;

import javax.swing.*;
import java.awt.event.*;

public class Accueil extends JFrame {
    private JPanel contentPane;
    private JButton buttonAccueil;
    private JButton buttonQuitter;
    private JButton clientButton;
    private JButton prospectButton;
    private JButton modificationButton;
    private JButton creationButton;
    private JButton suppressionButton;
    private JButton affichageButton;
    private JPanel accueilQuitter;
    private JPanel Accueil2;
    private JPanel Accueil1;
    private JComboBox comboBox1;
    private JPanel Accueil3;
    private JLabel change;
    private SocieteChoix societeChoix;
    private JLabel gestionLabel;

    public Accueil() {
        initFrame();
        afficherPanel();
        listeners();
        getRootPane().setDefaultButton(buttonAccueil);


    }



    private void initFrame() {
        setContentPane(contentPane);
        setTitle("Accueil");
        setSize(600, 400);

        }

        private void afficherPanel(){
            Accueil2.setVisible(false);
            Accueil3.setVisible(false);
        }

        public void preRemplirChamps(){

        }

        private void listeners(){

            clientButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Accueil2.setVisible(true);
                    change.setText("Gestion des clients"); // Met à jour le texte
                 societeChoix = SocieteChoix.CLIENT;
                }
            });

            prospectButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Accueil2.setVisible(true);
                    change.setText("Gestion des prospects"); // Met à jour le texte
                    societeChoix = SocieteChoix.PROSPECT;
                }
            });

            creationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MiseAjour(societeChoix).setVisible(true);
                    change.setText("Gestion des clients");

                }
            });

            affichageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Ici je lui donne le choix, que tu a set au préalable
                    //Quand il a cliqué sur Client ou Prospect
                    new Liste(societeChoix).setVisible(true);

                }
            });





            buttonAccueil.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onOK();
                }
            });

            buttonQuitter.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }

            });
        }



    // Listener pour la fermeture de la fenêtre par la croix (fermeture par défaut)
//    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//    addWindowListener(new WindowAdapter() {
//        public void windowClosing(WindowEvent e) {
//            onCancel(); // Appelle la méthode pour annuler et fermer
//        }
//    });



    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }}


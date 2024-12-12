package view;

import entities.*;
import utilities.SocieteChoix;

import javax.swing.*;
import java.awt.event.*;

public class Accueil extends JFrame {
    private boolean isModification = false; // Indique si l'opération en cours est une modification ou non.
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
    private JButton validerChoixButton;
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
        setSize(900, 600);
    }

    private void afficherPanel() {
        Accueil2.setVisible(false);
        Accueil3.setVisible(false);
    }

    public void preRemplirChamps() {
        // À implémenter si nécessaire.
    }

    private void listeners() {
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Accueil2.setVisible(true);
                change.setText("Gestion des clients."); // Met à jour le texte.
                societeChoix = SocieteChoix.CLIENT;
            }
        });

        prospectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Accueil2.setVisible(true);
                change.setText("Gestion des prospects."); // Met à jour le texte.
                societeChoix = SocieteChoix.PROSPECT;
            }
        });

        creationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MiseAjour(societeChoix).setVisible(true);
                change.setText("Gestion des clients.");
            }
        });

        affichageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Liste(societeChoix).setVisible(true);
            }
        });

        modificationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Affiche le panel Accueil3.
                Accueil3.setVisible(true);

                // Vérifie si un choix a été fait.
                if (societeChoix == SocieteChoix.CLIENT) {
                    remplirComboBoxClients(); // Appelle une méthode pour remplir avec les clients.
                } else if (societeChoix == SocieteChoix.PROSPECT) {
                    remplirComboBoxProspects(); // Appelle une méthode pour remplir avec les prospects.
                } else {
                    JOptionPane.showMessageDialog(
                            Accueil.this,
                            "Veuillez sélectionner 'Client' ou 'Prospect' avant de modifier.",
                            "Erreur",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        });

        suppressionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Affiche le panel Accueil3.
                Accueil3.setVisible(true);

                // Vérifie si un choix a été fait.
                if (societeChoix == SocieteChoix.CLIENT) {
                    remplirComboBoxClients(); // Appelle une méthode pour remplir avec les clients.
                } else if (societeChoix == SocieteChoix.PROSPECT) {
                    remplirComboBoxProspects(); // Appelle une méthode pour remplir avec les prospects.
                } else {
                    JOptionPane.showMessageDialog(
                            Accueil.this,
                            "Veuillez sélectionner 'Client' ou 'Prospect' avant de supprimer.",
                            "Erreur",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        });

        validerChoixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Vérifie si un type a été sélectionné (Client ou Prospect).
                if (societeChoix == SocieteChoix.CLIENT || societeChoix == SocieteChoix.PROSPECT) {
                    // Récupère la valeur sélectionnée dans la combobox.
                    String selectedValue = (String) comboBox1.getSelectedItem();

                    if (selectedValue != null) {
                        // Détermine l'index sélectionné dans la comboBox.
                        int index = comboBox1.getSelectedIndex();

                        // Vérifie si l'index est valide.
                        if (index >= 0) {
                            if (societeChoix == SocieteChoix.CLIENT) {
                                // Récupère l'objet Client correspondant à l'index.
                                Client client = ListeClient.listeClient.get(index);


                                // Transmet les données du client à la page MiseAjour.
                                new MiseAjour(societeChoix, client).setVisible(true);

                            } else if (societeChoix == SocieteChoix.PROSPECT) {
                                // Récupère l'objet Prospect correspondant à l'index.
                                Prospect prospect = ListeProspect.listeProspect.get(index);

                                // Logique supplémentaire : récupérer les détails du prospect.
                                String raisonSociale = prospect.getRaisonSocialeSociete();
                                String telephone = prospect.getTelSociete();
                                String email = prospect.getEmailSociete();

                                // Transmet les données du prospect à la page MiseAjour.
                                new MiseAjour(societeChoix, prospect).setVisible(true);
                            }
                        } else {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Aucun élément valide sélectionné dans la liste.",
                                    "Erreur",
                                    JOptionPane.WARNING_MESSAGE
                            );
                        }
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Veuillez sélectionner un élément dans la liste.",
                                "Erreur",
                                JOptionPane.WARNING_MESSAGE
                        );
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Veuillez d'abord sélectionner 'Client' ou 'Prospect'.",
                            "Erreur",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
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

    private void remplirComboBoxClients() {
        comboBox1.removeAllItems(); // Vide la combobox.
        for (Client client : ListeClient.listeClient) {
            comboBox1.addItem(client.getRaisonSocialeSociete()); // Ajoute la raison sociale des clients.
        }
    }

    private void remplirComboBoxProspects() {
        comboBox1.removeAllItems(); // Vide la combobox.
        for (Prospect prospect : ListeProspect.listeProspect) {
            comboBox1.addItem(prospect.getRaisonSocialeSociete()); // Ajoute la raison sociale des prospects.
        }
    }

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        dispose();
    }
}

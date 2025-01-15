package view;

import entities.Client;
import entities.ListeClient;
import entities.ListeProspect;
import entities.Prospect;
import utilities.SocieteChoix;
import view.Liste;
import view.MiseAjour;

import javax.swing.*;
import java.awt.event.*;

/**
 * Classe principale représentant l'accueil de l'application.
 * Cette interface utilisateur permet la navigation entre différentes fonctionnalités
 * telles que la gestion des clients et prospects (création, modification, suppression et affichage).
 */
public class Accueil extends JFrame {

    /** Indique si l'opération en cours est une modification ou non. */
    private boolean isModification = true;

    /** Panneau principal de contenu. */
    private JPanel contentPane;

    /** Bouton pour revenir à l'accueil. */
    private JButton buttonAccueil;

    /** Bouton pour quitter l'application. */
    private JButton buttonQuitter;

    /** Bouton pour accéder à la gestion des clients. */
    private JButton clientButton;

    /** Bouton pour accéder à la gestion des prospects. */
    private JButton prospectButton;

    /** Bouton pour effectuer une modification. */
    private JButton modificationButton;

    /** Bouton pour créer un nouveau client ou prospect. */
    private JButton creationButton;

    /** Bouton pour supprimer un client ou prospect. */
    private JButton suppressionButton;

    /** Bouton pour afficher la liste des clients ou prospects. */
    private JButton affichageButton;

    /** Panneau contenant les boutons quitter et accueil. */
    private JPanel accueilQuitter;

    /** Panneaux secondaires affichés en fonction des interactions. */
    private JPanel Accueil2;
    private JPanel Accueil1;
    private JPanel Accueil3;

    /** Combobox pour afficher et sélectionner des clients ou prospects. */
    private JComboBox<String> comboBox1;

    /** Label indiquant l'état ou le mode courant (clients, prospects, etc.). */
    private JLabel change;

    /** Bouton pour valider une action sélectionnée. */
    private JButton validerChoixButton;

    /** Enumération indiquant le type de gestion en cours (client ou prospect). */
    private SocieteChoix societeChoix;

    /** Label pour afficher un message contextuel ou un titre de section. */
    private JLabel gestionLabel;

    /**
     * Constructeur principal de la classe Accueil.
     * Initialise les composants graphiques et configure les écouteurs d'événements.
     */
    public Accueil() {
        initFrame();
        afficherPanel();
        listeners();
        getRootPane().setDefaultButton(buttonAccueil);
    }

    /**
     * Initialise la fenêtre principale avec ses dimensions et son titre.
     */
    private void initFrame() {
        setContentPane(contentPane);
        setTitle("Accueil");
        setSize(900, 600);
    }

    /**
     * Cache certains panneaux secondaires par défaut lors de l'initialisation.
     */
    private void afficherPanel() {
        Accueil2.setVisible(false);
        Accueil3.setVisible(false);
    }

    /**
     * Préremplit les champs si nécessaire.
     * Cette méthode est prévue pour une implémentation future si besoin.
     */
    public void preRemplirChamps() {
        // À implémenter si nécessaire.
    }

    /**
     * Configure les écouteurs d'événements pour les différents boutons de l'interface.
     */
    private void listeners() {
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Accueil2.setVisible(true);
                change.setText("Gestion des clients."); // Met à jour le texte pour indiquer la gestion des clients.
                societeChoix = SocieteChoix.CLIENT;
            }
        });

        prospectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Accueil2.setVisible(true);
                change.setText("Gestion des prospects."); // Met à jour le texte pour indiquer la gestion des prospects.
                societeChoix = SocieteChoix.PROSPECT;
            }
        });

        creationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MiseAjour(societeChoix).setVisible(true); // Ouvre la fenêtre de création pour clients/prospects.
                change.setText("Création en cours.");
            }
        });

        affichageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Liste(societeChoix).setVisible(true); // Ouvre la liste des clients/prospects.
            }
        });

        modificationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Accueil3.setVisible(true);// Affiche le panneau pour la sélection.
                isModification = false;
                if (societeChoix == SocieteChoix.CLIENT) {
                    remplirComboBoxClients(); // Remplit la liste déroulante avec les clients.
                } else if (societeChoix == SocieteChoix.PROSPECT) {
                    remplirComboBoxProspects(); // Remplit la liste déroulante avec les prospects.
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
                Accueil3.setVisible(true); // Affiche le panneau pour la sélection.
                if (societeChoix == SocieteChoix.CLIENT) {
                    remplirComboBoxClients();
                } else if (societeChoix == SocieteChoix.PROSPECT) {
                    remplirComboBoxProspects();
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
                String selectedValue = (String) comboBox1.getSelectedItem();

                if (selectedValue != null) {
                    int index = comboBox1.getSelectedIndex();

                    if (index >= 0) {
                        if (societeChoix == SocieteChoix.CLIENT) {
                            Client client = ListeClient.listeClient.get(index);
                            new MiseAjour(societeChoix, client,isModification).setVisible(true); // Mode readonly
                        } else if (societeChoix == SocieteChoix.PROSPECT) {
                            Prospect prospect = ListeProspect.listeProspect.get(index);
                            new MiseAjour(societeChoix, prospect, isModification).setVisible(true); // Mode readonly
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
            }
        });

        buttonAccueil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(); // Ferme la fenêtre et revient à l'accueil.
            }
        });

        buttonQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Quitte l'application.
            }
        });
    }

    /**
     * Remplit la combobox avec les noms des clients disponibles.
     */
    private void remplirComboBoxClients() {
        comboBox1.removeAllItems(); // Vide la combobox.
        for (Client client : ListeClient.listeClient) {
            comboBox1.addItem(client.getRaisonSocialeSociete()); // Ajoute les noms des clients.
        }
    }

    /**
     * Remplit la combobox avec les noms des prospects disponibles.
     */
    private void remplirComboBoxProspects() {
        comboBox1.removeAllItems(); // Vide la combobox.
        for (Prospect prospect : ListeProspect.listeProspect) {
            comboBox1.addItem(prospect.getRaisonSocialeSociete()); // Ajoute les noms des prospects.
        }
    }

    /**
     * Ferme la fenêtre actuelle.
     */
    private void onOK() {
        dispose();
    }

    /**
     * Annule et ferme la fenêtre actuelle.
     */
    private void onCancel() {
        dispose();
    }
}

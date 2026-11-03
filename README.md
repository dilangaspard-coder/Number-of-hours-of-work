# TEMPO — Mon suivi d’heures

Application réalisée à partir des trois fichiers Java `Count.java`, `Date.java` et `Main.java`.
Elle reprend ton idée : définir un nom, un objectif d’heures et une date limite, puis ajouter du travail et suivre le total.

## Démarrage immédiat (Mac / Windows / Linux)

Ouvre le fichier `working-hours.html` (livré séparément) dans un navigateur moderne. Il n’y a rien à installer, ni Java ni serveur à démarrer.

## Version installable (dossier `tempo-app`)

1. Décompresse `tempo-app.zip`.
2. Publie le contenu du dossier sur un hébergeur de fichiers statiques accessible en HTTPS, par exemple Netlify Drop. Le fichier `index.html` doit être à la racine du site publié.
3. Ouvre l’adresse HTTPS sur téléphone ou ordinateur.
4. Sur iPhone (Safari) : Partager > Sur l’écran d’accueil. Sur Chrome/Edge, utilise « Installer l’application » si le navigateur le propose.

Tu peux également tester la version web localement avec :

    cd tempo-app
    python3 -m http.server 8000

Ouvre ensuite http://localhost:8000/. L’installation PWA n’est pas garantie depuis tous les navigateurs en mode local ; elle fonctionne sur un hébergement HTTPS compatible.

## Fonctionnalités

- Configuration du prénom, de l’objectif et de la date limite.
- Ajout de sessions avec date, heures, minutes et note facultative.
- Historique consultable, avec modification et suppression.
- Calcul automatique des heures effectuées et restantes, de la progression, et d’un rythme journalier moyen recommandé.
- Histogramme de la semaine.
- Données conservées automatiquement dans le stockage local du navigateur (localStorage).
- Export JSON intégral (sauvegarde), restauration JSON, export CSV de l’historique.
- Fonctionne hors ligne si les fichiers sont locaux ou après installation/mise en cache de la version hébergée.

## Important : confidentialité et sauvegardes

Il n’y a pas de compte, de serveur, ni de synchronisation entre appareils. Les données ne quittent pas ton appareil, sauf si tu exportes volontairement un fichier.
Les données peuvent être perdues si tu changes de navigateur/appareil ou si tu effaces les données du site. Pense à télécharger régulièrement une sauvegarde JSON depuis Paramètres !

## Base du code Java

- `Count`: nom, objectif, heures accumulées -> profil et somme des sessions.
- `Date`: jour/mois/année -> date sélectionnée avec champ date natif et validation calendaire.
- `Main`: interaction quotidienne -> formulaire, tableau de bord et historique.

Le code original Java ne s’exécute pas dans le navigateur : la même logique a été réécrite en JavaScript dans `index.html`.

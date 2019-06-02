
# PPE-JAVA | Inscriptions Sportives
***

## Mise en situation 
Cette situation professionnelle est réalisée dans le contexte de la M2L, ou la maison des ligues de Lorraine. Sa mission est de fournir aux ligues sportives différents services. De plus, elle gère l’organisation de compétitions et ainsi la gestion des équipes et des personnes y participant. 

## Technologie 

Cette Apllication JAVA est un fork du projet [inscriptionsSportives](https://github.com/alexandreMesle/inscriptionsSportives).

inscriptionsSportives est un projet java qui a été imposé comme base de départ pour notre projet.

De plus il nous été imposé d'utilisé [Hibernate](https://hibernate.org/) comme ORM. 

## Décomposition du projet

Le projet se décompose en 4 itérations majeure.

###### Itération 1
- Tests unitaires
- Ajout des fonctionalités manquantes, indiquées dans le code avec des //TODO
- Ajout d’exceptions dans la couche métier pour gérer les erreurs
- Modélisation de la base de données
- MCD

###### Itération 2
  - Création d’une base de données
  - Installation de la base de données sur un serveur
  - Mise en place d’un dialogue utilisateur à l’aide de la bibliothèque [CommandLine](https://github.com/alexandreMesle/CommandLine)
  
###### Itération 3
  - Connexion à la base de données avec Hibernate
  - Réflexion sur le maquettage des fenêtres

###### Itération 4
  - Développement d’une IHM en Java (Swing)
  - Documentation utilisateur

  
## Installation 

#### Prérequis
* JAVA
* PostgreSQL
* [Maven](https://maven.apache.org/)
* [CommandLine](https://github.com/alexandreMesle/CommandLine) 

#### Procédure
- Une fois téléchargé CommandLine accolé le au dossier InscriptionsSportives et vérifiez que le lien dans le Build Path est fonctionnel.

- Lancez un "update project" de maven.

- Dans le dossier `src/main/ressources` copiez le fichier `hibernate.cfg.xml.example` en `hibernate.cfg.xml`.

- Configurez le fichier `hibernate.cfg.xml` pour qu'il puisse avoir accès à la base de donnée PostgreSQL.

- L'application possède deux mode de lancement une version cli et une version graphique. 
## Auteurs

* **Tao Berquer** - [www.taoberquer.fr](https://www.taoberquer.fr/)
* **Alexandre Kaprielian** - [www.alexandre-kaprielian.com](www.alexandre-kaprielian.com)
* **Brahim Mlaghui** - [www.mlaghuibrahim.com](http://www.mlaghuibrahim.com/)

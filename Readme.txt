Proxibanque V4.0:
*****************
Membres : 

Widad Cadi / Zineb Sidelkhir / Rabie Habachi / Ismail Norri / Mohamed Bourkha;

==================================================================================

I/Introduction:

Proxibanque est une application conçue pour :

#Le gérant de l'agence bancaire afin de lui permettre la gestion des conseillers clientèles.
#Les conseillers afin de leur permettre la gestion de leurs portefeuilles clients et leurs comptes bancaires.
#Paramétrage afin de lui permettre le parametrage de nombre clients affecter au conseillers et le nombre de conseillers affecter aux gerant

==================================================================================

II/Fonctionnalités:


L'application permet de réaliser les opérations suivantes :


Pour le gérant:
*************** 
	- Ajouter un conseiller;
	- Consulter la liste des clients non affectés;
	- Affecter un client non affecté à un conseiller;
	- Consulter le rapport des transactions de la semaine ou des 6 derniers mois.
	- Consulter la liste des conseillers dont les clients sont à découvert.

Pour le conseiller:
*************** 
	- Ajouter un client;
	- SUpprimer un client;
	- Modifier un client;
	- Consulter la liste des clients;
	- Consulter les comptes d'un client ;
	- Effectuer un virement d'un montant d'un compte vers un autre, c'est-à-dire, retirer
      	  le montant du compte et le verser vers l'autre compte :
		Pour un compte courant, le retrait peut s'effectuer à condition que le solde final ne soit pas inférieur au découvert.
	-Consulter la liste des clients qui sont à découvert

Pour le Paramétrage
*************** 
	- Modifier comission d'un conseiller
	- Modifier nombre clients d'un conseiller
	- Modifier nombre conseillers d'un gerant
	- Modifier style de graphe (histogramme,camambert)(en cours...)



	#Chaque compte est défini par un numéro, un solde et une date de création ;
	#Il existe deux types de comptes : les comptes courants et les comptes épargnes ;
	#Un compte courant est un compte qui possède en plus un découvert ;
	#Un compte épargne est un compte qui possède en plus un taux de rémuneration ;
	#Chaque compte appartient à un client et créé par un conseiller;
	#Chaque client est défini par son id, son nom et prenom, son adresse, sa ville, son téléphone et un code postal;
	#Un conseiller est créé par le gérant, et est défini aussi par son id et son nom et prenom, son adresse,son email et son login et mot de passe;
	#Chaque compte peut subir une opération de virement;	#Chaque compte peut subir une opération de virement;


==================================================================================

III/Installation:

Les diagrammes de classes de cas d'utilisation et de déploiement ainsi que le sql et les maquettes sont dans le dossier "conception"
Pour utiliser ProxiBanqueSI V4.0 : 

======== Installer l'application ========

1) déziper dans un dossier le fichier "ProxiBanqueV4.zip"
2) ouvrir une console
3) aller jusqu'au dossier src de proxibanque.
4) taper : mvn clean package 
6) puis : target\proxiBanqueV4.war S:\apache-tomcat-9\webapps\ProxiBanqueV4.war

======== Créer la base de donnée MySQL ========

1) Ouvrir Xampp
2) Lancer Apache
3) Lancer MySQL
4) Lancer le controle Admin de MySQL sur Xampp
5) Cliquer sur l'onglet "console" de Xampp
6) taper : "mysql -u root -p" puis tapez [entrée]
7) Ouvrir le dossier conception et ouvrez dans un éditeur texte le fichier "proxibanqueversion4.sql"
8) Copier l'entièreté du fichier
9) Dans la console, coller le texte copié.
10) La base de donnée a été crée dans MySQL.

======== Lancer l'application ========

1) Lancer serveur d'application 
2)Sur le terminal d'un éditeur de texte (VisualCode) lancez la commande "npm install -g @angular/cli"

3)Ouvrez le dossier FrontEndPBqV4-master dans un éditeur de texte (VisualCode)

4)Lancez la commande npm start

5) Ouvrez un navigateur internet
6) Tapez dans l'url : http://localhost:4200/

==================================================================================

IV_Utilisation
;
Au démarrage l'application ProxiBanqueV4 affiche une page d'accueil avec trois espaces (gérant, conseiller, paramètrage).

Pour le gérant:
*************** 

	- cliquez sur accéder. Une page d'authentification s'affiche où un login et un mot de passe sont demandés.

Par défaut 1 seul gérant de l'agence  a été définit avec:
 
		#login: jawad@gmail.com;
		#mot de passe : jawad.

Si le login ou le mot de passe est incorrect, un message vous demandant de vous connecter avec de bons paramètres d'identification apparaîtra.

=== Une fois identifié ===

Une page "Liste des conseillers" vous liste les conseillers existants dans l'agence avec leur informations. Pour chaque conseiller se trouve 
un bouton "Affecter Client".

Le nom et prénom du gérant est alors affiché dans la barre de navigation ainsi que les boutons "Ajouter Conseiller" et "Rapport de transactions"


	[Ajouter Conseiller]

	        #En renseignant le formulaire qui apparaît après avoir cliquer sur le bouton "Ajouter" vous pouvez créer un nouveau conseiller.
		#Une fois le bouton [Ajouter] cliqué, la page d'accueil est mise à jour et le nouveau client apparait dans le tableau.
Si l'un des champs n'est pas rempli, un message vous demandant de remplir tous les champs  apparaîtra.
		
        [Affecter Client]
 
		# Une fois cliqué une nouvelle page vous affiche la liste des clients non affectés.
		# En cliquant sur le bouton + se trouvant dans la ligne d'un client non affecté, il sera automatiquement affecté au conseiller de départ.
		# Le client sera ajouté à la liste des clients du conseiller.
		
	[Rapport de transactions]

		# Une fois cliqué une nouvelle page vous affiche le rapport des transactions de la semaine, et un bouton "Transaction/6mois" vous permettra 
		  de voir le rapport sur les 6 derniers mois.
		
	[Suppression]

		#Une fois cliqué, le conseiller est supprimé de la liste et de la Base de Donnée.
Un message vous demandant de valider la supression apparaîtra.

	[Alerte]

		#Une alerte est affichée dans la barre de navigation du gérant dés sa connexion si l'un des conseillers a un client à découvert.
		#En cliquant dessus, une liste contenant les conseillers ayant des clients à découvert s'affiche.


A chaque étape de votre navigation, le bouton Proxibanque vous permettra de vous revenir à la page principal qui est la liste des conseillers.
A chaque étape de votre navigation, le bouton [Logout] bleu vous permettra de vous deconnecter et de revenir à l'accueil.


Pour le conseiller:
*******************

	- cliquez sur accéder. Une page d'authentification s'affiche où un login et un mot de passe sont demandés.

Par défaut 2 conseillers de clientèle ont été définis avec 
	- conseiller 1:
		# login :"zineb@gmail.com"			
		# password "zinebproxi"
	- conseiller 2:
		# login :"mouhamed@gmail.com"			
		# password "mouhamedproxi"

Si le login ou le mot de passe est incorrect, une page vous demandant de vous connecter avec de bons paramètres d'itentification apparaîtra. 


    
=== Une fois identifié ===

Une page "Liste des clients" vous liste les clients qui sont associés au conseiller connecté avec leurs informations, ainsi que les opérations
pouvant être effectuées pour chaque client.
Le nom et prénom du conseiller sont alors affichés dans la barre de navigation ainsi que les boutons "Ajouter Client" et "Effectuer virement".

Plusieurs choix s'offrent à vous :

	[Ajouter Client]

	        #En renseignant le formulaire qui apparaît aprés avoir cliquer sur le bouton "Ajouter" vous pouvez créer un nouveau client.
		#Une fois le bouton [Ajouter] cliqué, la page d'accueil est mise à jour et le nouveau client apparait dans le tableau.
Si l'un des champs n'est pas rempli, un message vous demandant de remplir tous les champs  apparaîtra.
		
        [Modifier Client] 

		#Une fois le bouton cliqué une nouvelle page apparait vous affichant les caractéristiques du client. 
		#Il vous est alors possible de modifier ses caractéristiques à partir du formulaire puis en cliquant sur le bouton [Modifier]
		Vous retournez au menu principal "Liste des Clients".
		
        [Liste des comptes] 
		# Une fois cliqué une nouvelle page vous affiche la liste des comptes du clients trié par Compte Courant et Compte Epargne.
		
	[Virements] 
		# Une fois cliqué une nouvelle page de virement s'affiche.
		# Vous pouvez effectuer des virements comptes à comptes avec le formulaire : 
			- sélectionner le compte à débiter
			- sélectionner le compte à créditer
			- sélectionner le montant
			- cliquer sur [effectuer le virement]
			- La page est alors mise à jour avec un message de validation.
		# Pour revenir à la liste des clients cliquez sur l'onglet "Liste des Clients" au centre de la page.
Si le montant du compte à débiter est inférieur au montant de la transaction, un message d'erreur s'affichera.
Si l'un des champs n'est pas rempli, un message vous demandant de remplir tous les champs  apparaîtra.
		
	[Suppression]

		#Une fois cliqué, le client est supprimé de la liste et de la Base de Donnée.
A chaque étape de votre navigation, le bouton Proxibanque vous permettra de vous revenir à la page principal qui est la liste des clients.
A chaque étape de votre navigation, le bouton [Logout] bleu vous permettra de vous deconnecter et de revenir à l'accueil de l'application.

Pour le paramètrage: 
*******************

	- cliquez sur accéder. Une page d'authentification s'affiche où un login et un mot de passe sont demandés.

Par défaut un login et un mot de passe ont été définit pour l'administrateur chargé de parametrer l'application
	
		# login :"parametrage@gmail.com"			
		# password "mako"


Si le login ou le mot de passe est incorrect, une page vous demandant de vous connecter avec de bons paramètres d'itentification apparaîtra. 

    
=== Une fois identifié ===

	        #Une page de paramètres est affiché.
		#Vous pouvez alors les modifier, ou cliquer sur le bouton "Paramètres par défaut" , pour revenir aux paramètres par défaut.
		#Une fois cliqué sur modifié, la page est mise à jour avec un message de validation.
Le bouton [Logout] bleu vous permettra de vous deconnecter et de revenir à l'accueil de l'application.

## V_EVOLUTIONS
    - Dans de futures versions, l'application pourra proposer à ses acteurs d'autres fonctionnalités telle que la gestion des patrimoines et calcul de crèdit.

===========================================================================

L'application respecte les critères suivants :
Elle se compose de trois couches : Entites,DAO, Metier;
L'invertion de controle avec Spring IOC 
La Couche Service : EJB sauf le virement qui est un WebService REST;
La Base de données est MySQL;
L'accès aux données avec JPA;
Le serveur d’application utilisé est Tomcat.
La partie FrontEnd avec le framework Angular
La partie log avec log4J

# TP 7 :  
> Activer le 2nd-level cache, mesurer avant/après, supprimer N+1 via JOIN FETCH et entity graph  

# Objectifs : 
 - Activer le cache de second niveau dans Hibernate  
 - Mesurer les performances avant et après l'activation du cache  
 - Identifier et résoudre les problèmes de requêtes N+1  
 - Utiliser JOIN FETCH et les entity graphs pour optimiser le chargement des relations

# Test 1 : Problème N+1 sans optimisation
> Création des tables et insertion des valeurs : 
<img width="1443" height="753" alt="image" src="https://github.com/user-attachments/assets/6174c91b-571b-4ca4-b824-96854b29c8ac" />
<img width="1600" height="228" alt="image" src="https://github.com/user-attachments/assets/5e929d98-24a0-4744-8cea-835bf1485513" />
<img width="1567" height="757" alt="image" src="https://github.com/user-attachments/assets/59598d1e-57ee-495c-a0cf-8a2b963b2317" />
<img width="1453" height="591" alt="image" src="https://github.com/user-attachments/assets/4d5decdd-a721-4120-8cd0-306b58ef999b" />
<img width="1600" height="751" alt="image" src="https://github.com/user-attachments/assets/f5ef43e7-39fd-4494-8bd2-a6ae766363c3" />
<img width="1268" height="697" alt="image" src="https://github.com/user-attachments/assets/ae692977-d092-4be1-af3d-87c4f31cf24d" />
<img width="1534" height="695" alt="image" src="https://github.com/user-attachments/assets/1196ae05-908e-4256-9420-20320d13620d" />
<img width="1483" height="687" alt="image" src="https://github.com/user-attachments/assets/7424217f-14ec-4a06-ab38-18b57bf44c16" />
<img width="1483" height="696" alt="image" src="https://github.com/user-attachments/assets/9b44ea4b-b3f2-4da9-97a5-04e5f23d921b" />
<img width="1583" height="682" alt="image" src="https://github.com/user-attachments/assets/876d2992-0f58-402d-acc4-b27d6ad2c210" />
<img width="1337" height="686" alt="image" src="https://github.com/user-attachments/assets/3b258f96-658f-4549-8e46-aa840b22d63d" />
<img width="1202" height="701" alt="image" src="https://github.com/user-attachments/assets/747f37f6-aef4-43f8-840e-c06bb5473e79" />
<img width="1438" height="699" alt="image" src="https://github.com/user-attachments/assets/7cb48f6d-5f7a-472a-b0bc-dfab99bfa289" />
<img width="1439" height="738" alt="image" src="https://github.com/user-attachments/assets/50e18cea-f8b1-48ac-979e-7d7c2ca95272" />
<img width="1600" height="749" alt="image" src="https://github.com/user-attachments/assets/8bc584b0-bd05-42db-addd-8e0e30fabe3c" />
<img width="1431" height="534" alt="image" src="https://github.com/user-attachments/assets/b4126fed-d2cc-4b3d-a086-b11eb6f6d5a8" />
<img width="1379" height="526" alt="image" src="https://github.com/user-attachments/assets/a4733133-3a16-45c5-8cf5-24bff2b0ae1e" />
<img width="1457" height="527" alt="image" src="https://github.com/user-attachments/assets/e303475b-a8fb-4239-8bc7-6580ebfa31f5" />
<img width="1600" height="510" alt="image" src="https://github.com/user-attachments/assets/0871f10e-2353-4858-9f99-cda466601606" />
<img width="1411" height="525" alt="image" src="https://github.com/user-attachments/assets/9601d98a-f62c-4966-9a70-4acf6b17e463" />
<img width="1406" height="528" alt="image" src="https://github.com/user-attachments/assets/2f051fe4-b93a-4ec6-9af6-8c1d7e7d0c4e" />
<img width="1408" height="525" alt="image" src="https://github.com/user-attachments/assets/3bc01d12-878f-4dfb-b179-b046af03a877" />
<img width="1408" height="522" alt="image" src="https://github.com/user-attachments/assets/a1041b21-39da-494d-b1de-67d4416a923e" />
<img width="1326" height="528" alt="image" src="https://github.com/user-attachments/assets/d40e3d90-7ea2-4247-a41c-541113e40295" />
<img width="1389" height="526" alt="image" src="https://github.com/user-attachments/assets/77a7248f-d4d5-4916-9baa-746c7a771e7c" />
<img width="1503" height="528" alt="image" src="https://github.com/user-attachments/assets/03221919-6f9e-477d-acab-878ad9eb9081" />
<img width="1441" height="526" alt="image" src="https://github.com/user-attachments/assets/877cc6ca-c297-4af5-8338-ab32cb4ebcc0" />
<img width="1485" height="529" alt="image" src="https://github.com/user-attachments/assets/3c4d1317-6321-42d6-b184-aecedb934742" />
<img width="1437" height="531" alt="image" src="https://github.com/user-attachments/assets/9c288ad5-4697-4053-86a4-bfb89ee74fb1" />
<img width="1453" height="530" alt="image" src="https://github.com/user-attachments/assets/7721ede6-9a46-41ed-bd62-ef6854ec21cd" />
<img width="1521" height="522" alt="image" src="https://github.com/user-attachments/assets/5ffba7e0-0ea3-4dfe-9e2b-b3c51129b43c" />
<img width="1504" height="527" alt="image" src="https://github.com/user-attachments/assets/7b1ebb11-8a19-4981-b52e-6409f3c5d12e" />
<img width="1504" height="527" alt="image" src="https://github.com/user-attachments/assets/add43e53-5881-457e-b197-7372177f6e90" />
<img width="1348" height="528" alt="image" src="https://github.com/user-attachments/assets/b47b53b4-a8cd-4d26-97b7-c87800de68f2" />
<img width="1589" height="533" alt="image" src="https://github.com/user-attachments/assets/34c9e8d4-0051-4bfb-94a1-ee8f34be9aec" />
<img width="1389" height="528" alt="image" src="https://github.com/user-attachments/assets/65b54707-18ed-4a9c-9709-e7b4ca87e14f" />
<img width="1320" height="532" alt="image" src="https://github.com/user-attachments/assets/3b719810-7906-4805-b0e1-fe6428b87ea9" />
<img width="1455" height="531" alt="image" src="https://github.com/user-attachments/assets/14636233-9993-42f6-893b-889ebd1c1679" />
<img width="1479" height="534" alt="image" src="https://github.com/user-attachments/assets/745dcff7-d1b8-4f27-9c6a-8c48864287dd" />
<img width="1293" height="532" alt="image" src="https://github.com/user-attachments/assets/aa72cae3-f21f-4fd4-8b0a-49c64ba65191" />
<img width="1282" height="532" alt="image" src="https://github.com/user-attachments/assets/f0a14df1-bca5-4e12-bde8-df39d7d3025f" />
<img width="1412" height="527" alt="image" src="https://github.com/user-attachments/assets/5f970531-a11e-488a-aa77-0842ed899187" />
<img width="1299" height="530" alt="image" src="https://github.com/user-attachments/assets/f8d241f5-bc75-4d4d-b8a9-6beb5aee6085" />
<img width="1439" height="529" alt="image" src="https://github.com/user-attachments/assets/4ba3692b-9e1e-4543-9dd0-b02d48a03dc1" />
<img width="1359" height="795" alt="image" src="https://github.com/user-attachments/assets/af78edf8-5e2e-4d0a-9c4e-303ac7abd0dc" />
<img width="1282" height="393" alt="image" src="https://github.com/user-attachments/assets/7e963d86-29dd-4065-ac2f-276d3b8d6e9f" />
<img width="1600" height="667" alt="image" src="https://github.com/user-attachments/assets/18e63eb7-def8-43bd-8b6d-47e6bcfbac2f" />

# Test 2 : Résolution du problème N+1 avec JOIN FETCH

<img width="1434" height="460" alt="image" src="https://github.com/user-attachments/assets/b893072c-a0ed-4d2b-b241-3055b6304c3a" />
<img width="1082" height="726" alt="image" src="https://github.com/user-attachments/assets/7fd71fa6-f896-409c-84ed-1d5ea4e38e25" />
<img width="873" height="532" alt="image" src="https://github.com/user-attachments/assets/2403cec1-2d94-4dea-be87-96d710d63bc2" />

<img width="1077" height="637" alt="image" src="https://github.com/user-attachments/assets/3caa0384-a3da-4956-88f2-aa9f7beaf96d" />
<img width="1377" height="698" alt="image" src="https://github.com/user-attachments/assets/14d598dc-6dcd-4486-ada4-f17fd2f21cf1" />

# Test 3: Résolution du problème N+1 avec Entity Graphs
<img width="1020" height="724" alt="image" src="https://github.com/user-attachments/assets/cfdd1f84-7f29-475b-b147-f2eba748c78e" />
<img width="1600" height="824" alt="image" src="https://github.com/user-attachments/assets/44756eec-ffbb-4a5a-9541-35e06c858eba" />
<img width="1301" height="624" alt="image" src="https://github.com/user-attachments/assets/a1b948bf-1b9f-47a6-9dc7-fb25a33a2535" />
<img width="1373" height="890" alt="image" src="https://github.com/user-attachments/assets/8526bec6-acdf-459c-a1a4-293f940f34f9" />
<img width="1243" height="892" alt="image" src="https://github.com/user-attachments/assets/c6e2e39c-2fc2-4f74-a3c6-cb94f255716e" />
<img width="1292" height="828" alt="image" src="https://github.com/user-attachments/assets/9b5b8d94-6b5e-43b8-b902-749f75a1e55e" />
<img width="1134" height="630" alt="image" src="https://github.com/user-attachments/assets/15f7d261-f957-4680-83c0-6950d6ba5e28" />

# Test 4: Test du cache de second niveau
<img width="1201" height="504" alt="image" src="https://github.com/user-attachments/assets/b3013bda-52fd-4087-8a00-fae217a3ab78" />
<img width="1523" height="693" alt="image" src="https://github.com/user-attachments/assets/1b75c63c-0952-4cc9-9ef6-c1e0401f4bf6" />
<img width="1305" height="675" alt="image" src="https://github.com/user-attachments/assets/b2c4a2a8-b234-4ea4-a6e5-6b834390f0e0" />
<img width="1385" height="503" alt="image" src="https://github.com/user-attachments/assets/f41b3516-1824-437b-92a3-204c392f2c10" />
<img width="1497" height="759" alt="image" src="https://github.com/user-attachments/assets/361b6dd8-f731-43ec-a99d-44bd6d4e104f" />
<img width="1584" height="553" alt="image" src="https://github.com/user-attachments/assets/edc1366f-30f3-4a40-b8e4-4113649298da" />
<img width="1550" height="825" alt="image" src="https://github.com/user-attachments/assets/d2258aec-f04a-4295-b68c-f0189c8a5192" />

# Test 5: Comparaison des performances avec et sans cache  
 >  Test sans cache 
<img width="1165" height="497" alt="image" src="https://github.com/user-attachments/assets/3589264a-18ad-4426-a3b4-093c8c003f60" />
<img width="1494" height="788" alt="image" src="https://github.com/user-attachments/assets/761383f7-7f06-4d6e-baa2-dd4e731993e7" />
<img width="1334" height="800" alt="image" src="https://github.com/user-attachments/assets/f283d048-6a8d-48b6-a654-74e1b7ebd344" />
<img width="1316" height="796" alt="image" src="https://github.com/user-attachments/assets/028b2f6c-fac8-4ff2-8204-c0f02cb2bb4f" />
<img width="1548" height="872" alt="image" src="https://github.com/user-attachments/assets/8d5dbc5f-5285-42fb-9c1e-a33bdcdeb94e" />
<img width="1060" height="722" alt="image" src="https://github.com/user-attachments/assets/5f634fc0-e87b-4b73-925e-93ae2fa355c9" />
<img width="1366" height="400" alt="image" src="https://github.com/user-attachments/assets/013eb951-2fc6-427c-825d-47b290a0d08f" />

 > Test avec cache



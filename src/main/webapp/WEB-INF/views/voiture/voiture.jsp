<%@ include file="/WEB-INF/views/includes/include.jsp" %>
<!DOCTYPE html>
<html lang="fr">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Voitures</title>

  <!-- Custom fonts for this template-->
  <link href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
   <%@ include file="/WEB-INF/views/menu_left/menu_left.jsp" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
     <%@ include file="/WEB-INF/views/menu_top/menu_top.jsp" %>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-4 text-gray-800">Voitures</h1>

        </div>
        <!-- /.container-fluid -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary"><a class="btn btn-success btn-large" href="<c:url value="/voiture/nouveau"/>" >Ajouter Voiture</a></h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                 
                      <th>Image</th>
                      <th>Matricule</th>
                      <th>Marque</th>
                      
                      <th>Modele</th>
                      <th>Carburant</th>
                      <th>Etat</th>
                      <th>Prix</th>
                     
                        <th>Action</th>
                    </tr>
                  </thead>
                  
                  <tbody>
                  <c:set var="count" value="0"  />
                  <c:forEach items="${voitures}" var="voiture">
               		<c:set var="count" value="${count+1}"/>
                    <tr>
                      <td><center><img src="<%=request.getContextPath()%>/resources/images/image${count}.jpg" width="90px" height="90px"/></center></td>
                       <td>${voiture.getMatricule()}</td>
                       <td>${voiture.getMarque()}</td>
                      <td>${voiture.getModele()}</td>
                      <td>${voiture.getCarburant()}</td>
                       <td>${voiture.isReserver()?"<p>Reserver</p>":"<p color='red'>Disponible</p>"}</td>
                      <td>${voiture.getPrix()}/J</td>
                 
                   
                      <td><center> 
                        <!-- Button trigger modal -->
					<button type="button" class="btn btn-danger btn-circle" data-toggle="modal" data-target="#voitureModal${voiture.getId()}">
					  <i class="fas fa-trash"></i></a>
					</button>
					
					<!-- Modal -->
					<div class="modal fade" id="voitureModal${voiture.getId()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					  <div class="modal-dialog modal-dialog-centered" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLongTitle">supprission de la voiture: ${voiture.getId()}</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					      		<p>êtes-vous sûr de vouloir supprimer définitivement cette voiture?</p>
								<h5>Matricule : ${voiture.getMatricule()}</h5>
							    <h5>Modele : ${voiture.getModele()}</h5>
							     <h5>Maeque : ${voiture.getMarque()}</h5>
							     
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
					        <c:url value="/voiture/supprimer/${voiture.getId()}" var="suppReser"/>
						                  <a href="${suppReser}" class="btn btn-danger btn-icon-split">
						                  
						                    <span class="text">Supprimer</span>
						                  </a>
					      </div>
					    </div>
					  </div>
					</div>
                       <c:url value="/voiture/modifier/${voiture. getId()}" var="urlmodifier"/>
                        <a href="${urlmodifier}" class="btn  btn-warning btn-circle"> <span class="fas fa-edit"></span> </a>
                        
                         <a href="javascript(0)" class="btn btn-info btn-circle" data-toggle="modal" data-target="#voitureModall${voiture.getId()}"> <i class="fas fa-info-circle"></i></a>  
                         
                         <div class="modal fade" id="voitureModall${voiture.getId()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLabel">Informations complete sur la voiture</h5>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body">
							     
							            <h5>Matricule : ${voiture.getMatricule()}</h5>
							            <h5>Modele : ${voiture.getModele()}</h5>
							              <h5>Maeque : ${voiture.getMarque()}</h5>
							            <h5>carburant : ${voiture.getCarburant()}</h5>
							            <h5>Date d'assurance : ${voiture.getAssurance()}</h5>
							            <h5>Date de visite : ${voiture.getVisite()}</h5>
							            <h5>kilometrage : ${voiture.getKilometrage()}</h5>
							              <h5>Prix/J : ${voiture.getPrix()}</h5>
							                <h5>Etat de voiture : ${voiture.isReserver()?"Reserver":"Disponible"}</h5>
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
							         
													      
			                    </div>
							    </div>
							  </div>
							</div>
							<c:choose>
								<c:when test="${!voiture.isReserver()}">
									<c:url value="/voiture/reserver/${voiture.getId()}" var="urlreserver"/>
								</c:when>
								<c:otherwise>
									<c:url value="#" var="urlreserver"/>
								</c:otherwise>
							</c:choose>   
						  
                        <a href="${urlreserver}" class="btn  btn-success btn-circle"> <span class="fas fa-plus"></span> </a>
                      </center> </td>
                    </tr>
                      </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">a</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
<%--   <script src="<%=request.getContextPath()%>/resources/vendor/jquery-easing/jquery.easing.min.js"></script> --%>

  <!-- Custom scripts for all pages-->
  <script src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script>


 

 
  

  <!-- Custom scripts for all pages-->
 

  <!-- Page level plugins -->
  <script src="<%=request.getContextPath()%>/resources/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
 <script src="<%=request.getContextPath()%>/resources/js/demo/datatables-demo.js"></script> 

</body>

</html>
 
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form action="../addSpecialist" method="post">

					<div class="form-group">
						<label>Enter Specialist Name</label> <input type="text"
							name="specName" class="form-control">
					</div>
					<div class="text-center mt-3">
						<button type="submit" class="btn btn-success">Add</button>
					</div>

				</form>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger"
					data-bs-dismiss="modal">Close</button>

			</div>
		</div>
	</div>
</div>

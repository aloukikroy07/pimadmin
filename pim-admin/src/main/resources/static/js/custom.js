
function loadCompanyEditData(el, dd){	
		var editModal = document.getElementById('editCompanyModal');
		var parentNode = el.parentNode.parentNode.parentNode.parentNode;
		
		editModal.querySelector('#id').value = parentNode.querySelector('#cId').value;
		editModal.querySelector('#name').value = parentNode.querySelector('#cName').value;
		editModal.querySelector('#bankId').value = parentNode.querySelector('#cBankId').value;
		editModal.querySelector('#address').value = parentNode.querySelector('#cAddress').value;
		editModal.querySelector('#city').value = parentNode.querySelector('#cCity').value;
		editModal.querySelector('#state').value = parentNode.querySelector('#cState').value;
		editModal.querySelector('#country').value = parentNode.querySelector('#cCountry').value;
		editModal.querySelector('#phoneNo').value = parentNode.querySelector('#cPhoneNo').value;
		editModal.querySelector('#email').value = parentNode.querySelector('#cEmail').value;
		editModal.querySelector('#website').value = parentNode.querySelector('#cWebsite').value;
		editModal.querySelector('#status').value = parentNode.querySelector('#cStatus').value;
			
}

function loadBusinessUnitEditData(el, dd){	
	var editModal = document.getElementById('editBusinessUnitModal');
	var parentNode = el.parentNode.parentNode.parentNode.parentNode;
	
	editModal.querySelector('#id').value = parentNode.querySelector('#cId').value;
	editModal.querySelector('#unitName').value = parentNode.querySelector('#cUnitName').value;
	editModal.querySelector('#shortName').value = parentNode.querySelector('#cShortName').value;
	editModal.querySelector('#hierarchy').value = parentNode.querySelector('#cHierarchy').value;
	editModal.querySelector('#status').value = parentNode.querySelector('#cStatus').value;
		
}
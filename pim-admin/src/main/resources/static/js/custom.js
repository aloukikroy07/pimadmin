
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
			
			
}

function testStatus(el, dd){	
		console.log(el);
		console.log(el);
}
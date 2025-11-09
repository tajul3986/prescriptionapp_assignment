function validateForm() {
    const name = document.querySelector('[name="patientName"]').value;
    const age = document.querySelector('[name="patientAge"]').value;
    const gender = document.querySelector('[name="patientGender"]').value;

    if(!name || !age || !gender){
        alert("Please fill all mandatory fields!");
        return false;
    }
    if(age < 0 || age > 120){
        alert("Please enter a valid age!");
        return false;
    }
    return true;
}

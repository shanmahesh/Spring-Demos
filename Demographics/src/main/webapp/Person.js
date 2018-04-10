var app = angular.module('UserManagement', []);
alert("load..");
//Controller Part
app.controller('UserManagementController', function($scope, $http) {

	
    //Initialize page with default data which is blank in this example
    $scope.persons = [];
    $scope.form = {
        prsnId : -1,
        firstName : "",
        lastName : "",
        SSN : ""
    };

    //Now load the data from server
    _refreshPageData();

    //HTTP POST/PUT methods for add/edit person
    $scope.submitperson = function() {

        var method = "";
        var url = "";
        if ($scope.form.prsnId == -1) {
            //Id is absent so add person - POST operation
            method = "POST";
            url = 'addPerson';
        } else {
            //If Id is present, it's edit operation - PUT operation
            method = "PUT";
            url = 'editPerson/' + $scope.form.prsnId;
        }

        $http({
            method : method,
            url : url,
            data : angular.toJson($scope.form),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then( _success, _error );
    };

    //HTTP DELETE- delete person by Id
    $scope.removeperson = function(person) {
        $http({
            method : 'DELETE',
            url : 'deletePerson/' + person.prsnId
        }).then(_success, _error);
    };

    //In case of edit person, populate form with person data
    $scope.editperson = function(person) {
        $scope.form.firstName = person.firstName;
        $scope.form.lastName = person.lastName;
        $scope.form.SSN = person.SSN;
        $scope.form.prsnId = person.prsnId;
    };

    /* Private Methods */
    //HTTP GET- get all persons collection
    function _refreshPageData() {
    	alert("refresh page");
        $http({
            method : 'GET',
            url : 'person'
        }).then(function successCallback(response) {
            $scope.persons = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }

    function _success(response) {
        _refreshPageData();
        _clearForm()
    }

    function _error(response) {
        console.log(response.statusText);
    }

    //Clear the form
    function _clearForm() {
        $scope.form.firstName = "";
        $scope.form.lastName = "";
        $scope.form.SSN = "";
        $scope.form.prsnId = -1;
    };
});
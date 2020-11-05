//global variable
//accesible to all functions
//Brandon Edwards
var sol =
    [[0, 7, 0, 2, 3, 8, 0, 0, 0],
    [0, 0, 0, 7, 4, 0, 8, 0, 9],
    [0, 6, 8, 1, 0, 9, 0, 0, 2],
    [0, 3, 5, 4, 0, 0, 0, 0, 8],
    [6, 0, 7, 8, 0, 2, 5, 0, 1],
    [8, 0, 0, 0, 0, 5, 7, 6, 0],
    [2, 0, 0, 6, 0, 3, 1, 9, 0],
    [7, 0, 9, 0, 2, 1, 0, 0, 0],
    [0, 0, 0, 9, 7, 4, 0, 8, 0]];
//this function prints the board
var printBoard = function () {
    var element='r'
    var t=0;
    for(var i=11;i<20;i++){
        var temp= document.getElementById(element+i);
        temp.innerHTML=sol[0][t];
        t++;
    }
    var t=0;
    for(var i=21;i<30;i++){
        var temp= document.getElementById(element+i);
        temp.innerHTML=sol[1][t];
        t++;
    }
    var t=0;
    for(var i=31;i<40;i++){
        var temp= document.getElementById(element+i);
        temp.innerHTML=sol[2][t];
        t++;
    }
    var t=0;
    for(var i=41;i<50;i++){
        var temp= document.getElementById(element+i);
        temp.innerHTML=sol[3][t];
        t++;
    }
    var t=0;
    for(var i=51;i<60;i++){
        var temp= document.getElementById(element+i);
        temp.innerHTML=sol[4][t];
        t++;
    }
    var t=0;
    for(var i=61;i<70;i++){
        var temp= document.getElementById(element+i);
        temp.innerHTML=sol[5][t];
        t++;
    }
    var t=0;
    for(var i=71;i<80;i++){
        var temp= document.getElementById(element+i);
        temp.innerHTML=sol[6][t];
        t++;
    }
    var t=0;
    for(var i=81;i<90;i++){
        var temp= document.getElementById(element+i);
        temp.innerHTML=sol[7][t];
        t++;
    }
    var t=0;
    for(var i=91;i<100;i++){
        var temp= document.getElementById(element+i);
        temp.innerHTML=sol[8][t];
        t++;
    }
};

var newPuzzle= function(){
    var req= new XMLHttpRequest();
    req.open("GET", "https://sugoku.herokuapp.com/board?dificulty=hard", true);
    req.onload= function(){
        var data= JSON.parse(this.response);
        sol=data.board;
        printBoard(sol);
    };
    req.send();

};

var solve = function() {
    var nemptySpot = emptySpot(sol);
    var row = nemptySpot[0];
    var col = nemptySpot[1];// Uses array from emptySpot function to determine which spot to work on
    if (row=== -1){ //Ends the recursive loop
        console.log('Solved');
        printBoard(); //Makes sure board is updated once button is pressed
        return true;
    }
    for(var pSol =1; pSol<=9; pSol++){
        if (checkSudokuReq(sol, row, col, pSol)){
            sol[row][col] = pSol;
            console.log('Recursive call');
            if(solve(sol)){
                return true;
            }
        }
    }
    if (emptySpot(sol)[0] !== -1){
        //Sets spot to zero then backtrace
        sol[row][col] = 0;
        return false;
    } 
    return true;
};
var emptySpot= function(sol) { //Finds the next empty spot in Sudoku grid and puts them in an array.
    for (var i =0;i <9;i++) {
        for (var j =0; j <9; j++) {
            if (sol[i][j] ==0) 
                return [i, j];
        }
    }
    return [-1,-1];
};
var checkSudokuReq= function(sol, row, column, num){ //Checks rows, columns, and entire board to make sure the number being added is not already there, satisfying Sudoku req
    for(var i=0;i<sol[row].length;i++){
        if(sol[row][i]==num){
            return false;
        }
    }
    for(var j=0; j<sol.length;j++){
        if(sol[j][column]==num){
            return false;
        }
    }
    var testRow= Math.floor(row/3)*3;
    var testCol= Math.floor(column/3)*3; //These two statements get us to the first location of both row and col in order to iterate over the entire square for Sudoku reqs
    for(var i=0;i<3;i++){
        for(var j=0; j<3;j++){
            if(sol[testRow+i][testCol+j]==num){
                return false;
            }
        }
    }
    return true;

};
printBoard();

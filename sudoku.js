//global variable
//accesible to all functions
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
    var r11=document.getElementById('r11');
    r11.innerHTML= 'X';
};

var solve = function() {

};

var emptySpot= function(){ //Checks and finds the first empty spot in the sudoku board
    for(var i=0; i<9;i++){
        for(var j=0;j<9;j++){
            if(sol[i][j]==0){
                return [i,j];
            }
        }
        return [-5,-5];
    }
};

var checkSudokuReq= function(sol, row, column, num){ //Checks rows, columns, and entire board to make sure the number being added is not already there, satisfying Sudoku req
    for(var i=0;i<sol[row].length;i++){
        if(sol[row][i]==num){
            return false;
        }
    }
    for(var j=0; j<sol.length;j++){
        if(sol[i][column]==num){
            return false;
        }
    }
    var testRow= Math.floor(row/3)*3;
    var testCol= Math.floor(column/3)*3; //These two statements get us to the first location of both row and col in order to iterate over the entire square for Sudoku reqs

    for(var i=0;i<3;i++){
        for(var j=0; j<3;j++){
            if(sol[testRow+i][testCol[j]]==num){
                return false;
            }
        }
    }
    return true;

};
printBoard();

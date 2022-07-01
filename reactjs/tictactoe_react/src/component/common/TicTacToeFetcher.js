import { HttpPost } from "../../FetcherCommon";
/**
 * Post request to start the game and get the current board from the server
 */
export const startGame = async (params) => {
    const url = "http://127.0.0.1:8080/com.paribas.tictactoe/start"
    return HttpPost(url,{playerOne : params.playerOne, playerTwo : params.playerTwo})
}

/**
 * Post request to play and change the board at x,y
 */
export const playGame = async (params) => {
    const url = "http://127.0.0.1:8080/com.paribas.tictactoe/play"
    return HttpPost(url,{x : params.x, y: params.y})
}
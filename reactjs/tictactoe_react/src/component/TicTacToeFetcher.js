import { HttpPost } from "../FetcherCommon";

export const startGame = async (params) => {
    const url = "http://localhost:8080/tictactoe/start"
    return HttpPost(url,{playerOne : params.playerOne, playerTwo: params.playerTwo})
}

export const playGame = async (params) => {
    const url = "http://localhost:8080/tictactoe/play"
    return HttpPost(url,{x : params.x, y: params.y})
}
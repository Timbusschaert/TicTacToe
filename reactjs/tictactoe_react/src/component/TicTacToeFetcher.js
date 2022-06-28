import { HttpPost } from "../FetcherCommon";

export const startGame = async (params) => {
    const url = "http://127.0.0.1:8080/Tictactoe/start"
    return HttpPost(url,params)
}

export const playGame = async (params) => {
    const url = "http://localhost:8080/Tictactoe/play"
    return HttpPost(url,{x : params.x, y: params.y})
}
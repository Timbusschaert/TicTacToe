
import React, { Component } from "react"
import "./StartMenu.css"
import StartMenu from "./StartMenu";
import PlayMenu from "./playMenu";
import { startGame } from "./TicTacToeFetcher";
class Main  extends Component{
    
    constructor(props){
        super(props)
        this.state = {
            message : "",
            matrix :undefined,
            isStart : false
        }
    }
    
    play = (x,y) => {
        this.fetchBoard(x,y)
    }

    startNewGame = (params) => {
        this.fetchStart(params)
    }

    async fetchStart(params){
        const result = await startGame(params)
        if(result !== null){
            this.setState({
                matrix  : result.board,
                isStart : true ,
                message : result.message
            })
        }
    }
 
    render () {
        let content = (<StartMenu grid={this.state.matrix} click={this.startNewGame}/>)
        if(this.state.isStart === true){
            console.log(this.state.matrix)
            content = (<PlayMenu grid={this.state.matrix}/>)
        }
        return (
            <div className="StartMenu">
                <div className="Title">
                    <h1>TIC TAC TOE </h1>
                </div>
                <div className="main">
                    {content}
                </div>
            </div>
        )
    }

}export default Main
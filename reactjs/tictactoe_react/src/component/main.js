
import React, { Component } from "react"
import "./Main.css"
import StartMenu from "./StartMenu";
import PlayMenu from "./playMenu";
import { startGame } from "./TicTacToeFetcher";
class Main  extends Component{
    
    constructor(props){
        super(props)
        this.state = {
            message : "",
            matrix :undefined,
            isStart : false,
            isOver : false
        }
    }
    
    play = (x,y) => {
        this.fetchBoard(x,y)
    }

    startNewGame = (params) => {
        this.fetchStart(params)
    }

    restart =  () => {
        this.setState({
            isStart : false 
        })   
    }

    async fetchStart(params){
        const result = await startGame(params)
        if(result !== null){
            this.setState({
                matrix  : result.board,
                isStart : true ,
                message : result.message,
                isOver : result.over
            })
        }
    }
 
    render () {
        let content = (<StartMenu grid={this.state.matrix} click={this.startNewGame}/>)
        if(this.state.isStart === true){
            content = (<PlayMenu isOver={this.state.isOver} message={this.state.message} grid={this.state.matrix} callback = {this.restart}/>)
        }
        return (
           
            <div className="Menu">
                <div className="title">
                    <div className="tic"><h1>TIC</h1></div> <div className="tac" ><h1>TAC</h1></div><div className="toe"><h1>TOE</h1></div> 
                </div>
                <div className="main">
                    {content}
                </div>
            </div>
        )
    }

}export default Main
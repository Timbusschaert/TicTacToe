
import React, { Component } from "react"
import { Message } from 'primereact/message';
import Board from "./Board/board"
import { playGame } from "./TicTacToeFetcher";
import "./StartMenu.css"

class PlayMenu  extends Component{
    
    constructor(props){
        super(props)
        this.state = {
            message : this.props.message,
            matrix : this.props.board,
            isOver : false
        }
    }
    
    play = (x,y) => {
        this.fetchBoard(x,y)
    }

    async fetchtBoard(row,column){
        const params ={
            x : row,
            y : column
        }
        const result = await playGame(params)
        if(result !== null){
            this.setState({
                 matrix :result.board ,
                 message : result.message,
                 isOver : result.isOver
            })
        }
    }
    

    render () {
        return (
            <div className="PlayMenu">
                <div className="board">
                    <Board grid={this.props.grid} callback={this.fetchtBoard}/>
                </div>
                <div className="label">                 
                    <Message severity='info' text={this.state.message} className="name"  />
                </div>
            </div>
        )
    }

}export default PlayMenu
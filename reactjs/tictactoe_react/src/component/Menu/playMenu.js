
import React, { Component } from "react"
import { Message } from 'primereact/message';
import Board from "../Board/board"
import { playGame } from "../common/TicTacToeFetcher";
import "./StartMenu.css"
import { Button } from "primereact/button";

class PlayMenu  extends Component{
    
    constructor(props){
        super(props)
        this.state = {
            message : this.props.message,
            matrix : this.props.grid,
            isOver : this.props.isOver
        }
    }
    
    play = (x,y) => {
        this.fetchBoard(x,y)
    }

    async fetchBoard(row,column){
        const params ={
            x : row,
            y : column
        }
        const result = await playGame(params)
        if(result !== null){
            this.setState({
                 matrix :result.board ,
                 message : result.message,
                 isOver : result.over
            })
        }
    }
    

    render () {
        return (
            <div className="PlayMenu">
                <div className="board">
                    <Board grid={this.state.matrix} isPlayable={true} isOver={this.state.isOver} callback={this.play}/>
                </div>
                <div className="label">                 
                    <Message severity='info' text={this.state.message} className="name"  />
                </div>
                {
                    this.state.isOver === true &&
                    <div>
                    <Button className="button" label="Replay ?" onClick={(e) => this.props.callback()}></Button>
                    </div>
                }
            </div>
        )
    }

}export default PlayMenu
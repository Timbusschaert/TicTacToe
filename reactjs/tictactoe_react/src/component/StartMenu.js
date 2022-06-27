
import React, { Component } from "react"
import {DataTable} from 'primereact/datatable'
import {Column} from 'primereact/column'
import {InputText} from 'primereact/inputtext'
import {Button} from 'primereact/button'
import Board from "./Board/board"
import "./StartMenu.css"
import { startGame } from "./TicTacToeFetcher"
class StartMenu  extends Component{
    constructor(props){
        super(props)
        this.state = {
            players: {
                playerOne : '',
                playerTwo : ''
            },
            matrix : {}
        }
        this.onNameChangePlayerOne = this.onNameChangePlayerOne.bind(this)
        this.onNameChangePlayerTwo = this.onNameChangePlayerTwo.bind(this)
    }

    onNameChangePlayerOne(value){
        const tmp = this.state.players
        tmp.playerOne = value 
        this.setState ({
            players : tmp 
        })
    }


    onNameChangePlayerTwo(value){
        const tmp = this.state.players
        tmp.playerTwo = value 
        this.setState ({
            players : tmp 
        })
    }

    async startNewGame(event){
        const result = await startGame(this.state.players)
        if(result !== null){
            console.log(result)
        }
    } 

    render () {
        return (
            <div className="StartMenu">
                <div className="Title">
                    <h1>TIC TAC TOE </h1>
                </div>
                <div className="board">
                    <Board grid = {this.state.matrix}/>
                </div>
                <div className="players">
                   
                    <InputText className="name" value={this.state.playerOne}  placeholder="Player one" onChange={(e) => this.onNameChangePlayerOne(e.value)}/>

                    <InputText className="name" value={this.state.playerTwo}  placeholder="Player two" onChange={(e) => this.onNameChangePlayerTwo(e.value)}/> 
                </div>
                <div className="startButton">
                    <Button className="startGame" label="Start game !"  onClick={(e) => this.startNewGame(e)}  disabled={this.state.players.playerOne === '' || this.state.players.playerTwo === '' }/>
                </div>

            </div>
        )
    }

}export default StartMenu
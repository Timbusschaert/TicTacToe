
import React, { Component } from "react"
import {InputText} from 'primereact/inputtext'
import {Button} from 'primereact/button'
import Board from "./Board/board"
import "./StartMenu.css"
class StartMenu  extends Component{
    constructor(props){
        super(props)
        this.state = {
            players: {
                playerOne : '',
                playerTwo : ''
            },
            matrix : undefined
        }
        this.onNameChangePlayerOne = this.onNameChangePlayerOne.bind(this)
        this.onNameChangePlayerTwo = this.onNameChangePlayerTwo.bind(this)
    }

    onNameChangePlayerOne(value){
        let tmp = this.state.players
        tmp.playerOne = value 
        this.setState ({
            players : tmp 
        })
    }


    onNameChangePlayerTwo(value){
        let tmp = this.state.players
        tmp.playerTwo = value 
        this.setState ({
            players : tmp 
        })
    }

    click(){
        this.props.click(this.state.players)
    }

    render () {
        return (
            <div className="StartMenu">
               
                <div className="board">
                    <Board grid={this.state.matrix}/>
                </div>
                <div className="players">
                    <InputText className="name" value={this.state.playerOne}  placeholder="Player one" onChange={(e) => this.onNameChangePlayerOne(e.value)}/>
                    <InputText className="name" value={this.state.playerTwo}  placeholder="Player two" onChange={(e) => this.onNameChangePlayerTwo(e.value)}/> 
                </div>
                <div className="startButton">
                    <Button className="startGame" label="Start game !" onClick={(e) => this.click()}  disabled={this.state.players.playerOne === '' || this.state.players.playerTwo === '' }/>
                </div>

            </div>
        )
    }

}export default StartMenu
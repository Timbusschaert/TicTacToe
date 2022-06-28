
import React, { Component } from "react"
import {InputText} from 'primereact/inputtext'
import {Button} from 'primereact/button'
import Board from "./Board/board"
import "./StartMenu.css"
class StartMenu  extends Component{
    constructor(props){
        super(props)
        this.state = {
            playerOne : '',
            playerTwo : '',
            matrix : []
        }
        this.onNameChangePlayerOne = this.onNameChangePlayerOne.bind(this)
        this.onNameChangePlayerTwo = this.onNameChangePlayerTwo.bind(this)
    }

    onNameChangePlayerOne(value){
        this.setState ({
            playerOne : value 
        })
    }


    onNameChangePlayerTwo(value){        
        this.setState ({
            playerTwo : value 
        })
    }

    click(){
        const params  = {
            playerOne : this.state.playerOne,
            playerTwo : this.state.playerTwo

        }
        this.props.click(params)
    }

    render () {
        return (
            <div className="StartMenu">
               
                <div className="board">
                    <Board grid={this.state.matrix} isPlayable={false}/>
                </div>
                <div className="name">
                    Insert players names and start the game ! 
                </div>
                <div className="players">
                    <div className="player">
                        <label htmlFor="player1" className="block">Player one</label>
                        <InputText id="player1" className="input" value={this.state.playerOne}   onChange={(e) => this.onNameChangePlayerOne(e.target.value)}/>
                    </div>
                    <div className="player">
                        <label htmlFor="player2" className="block">Player two</label>
                        <InputText id="player2" className="input" value={this.state.playerTwo}   onChange={(e) => this.onNameChangePlayerTwo(e.target.value)}/> 
                    </div>
                </div>
                <div className="startButton">
                    <Button className="button" label=" Start game !" onClick={(e) => this.click()}  disabled={this.state.playerOne === '' || this.state.playerTwo === '' }/>
                </div>

            </div>
        )
    }

}export default StartMenu
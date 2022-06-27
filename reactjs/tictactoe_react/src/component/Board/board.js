import { DataTable } from "primereact/datatable"
import { Column } from "primereact/column"
import Circle from "./circle"
import React, { Component } from "react"
import Cross from "./cross"
import "./board.css"
class Board extends Component {
    

    constructor(props){
        super(props)
    }

    render () {
        return (
            <div className="grid">
                <div className="row">
                    <div className="cell"><Circle></Circle></div>
                    <div className="cell"><Cross></Cross></div>
                    <div className="cell"></div>
                </div>
                <div className="row">
                    <div className="cell"><Cross></Cross></div>
                    <div className="cell"><Circle></Circle></div>
                    <div className="cell"></div>
                </div>
                <div className="row">
                    <div className="cell"></div>
                    <div className="cell"><Circle></Circle></div>
                    <div className="cell"></div>
                </div>
            </div>
        )    
    }   
}export default Board
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

    getCellValue(name,x,y) {
        if(name === "EMPTY"){
            return (<div className="cell" onClick={(e) => this.props.callback(x,y)}></div>)
        }else if (name === "CROSS"){
            return (<div className="cell"><Cross></Cross></div>)
        }
        return (<div className="cell"><Circle></Circle></div>)
    }

    getBoard () {
        if(this.props.grid !== []){
            const row = this.props.grid.map((row,indexRow) => {
                let tmp = 0
                const columnDisplay  = row.map((column,indexColumn) => {
                    
                    return (this.getCellValue(column,indexRow,indexColumn))
                })
                return ( <div className="row"> {columnDisplay} </div>)
            }) 
            return ( <div className="grid">{row}</div>)     
        
        }else{
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
    }
        

    render () {
        return (this.getBoard()) 
    }   
}export default Board
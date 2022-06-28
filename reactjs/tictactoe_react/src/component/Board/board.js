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
            return (<div key={""+(3*x+y+1)} className={"cell cell"+(3*x+y+1)} onClick={(e) => this.callCallback(x,y)
                    
               }></div>
                )
        }else if (name === "CROSS"){
            return (<div key={""+(3*x+y+1)} className={"cell cell"+(3*x+y+1)} ><Cross></Cross></div>)
        }
        return (<div key={""+(3*x+y+1)} className={"cell cell"+(3*x+y+1)} ><Circle></Circle></div>)
    }

    callCallback =  (x,y) =>{
        if(!this.props.isOver){
            this.props.callback(x,y)
        }
        
    }
    
    getBoard () {
        if(this.props.isPlayable){
            const row = this.props.grid.board.map((row,indexRow) => {
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
                        <div className="cell cell1"><Circle></Circle></div>
                        <div className="cell cell2"><Cross></Cross></div>
                        <div className="cell cell3"></div>
                    </div>
                    <div className="row">
                        <div className="cell cell4"><Cross></Cross></div>
                        <div className="cell cell5"><Circle></Circle></div>
                        <div className="cell cell6"></div>
                    </div>
                    <div className="row">
                        <div className="cell cell7"></div>
                        <div className="cell cell8"><Circle></Circle></div>
                        <div className="cell cell9"></div>
                    </div>
                </div>
                )
        }
    }
        

    render () {
        return (this.getBoard()) 
    }   
}export default Board
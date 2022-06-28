import React ,{ Component } from "react"
import circle from "../../img/Red-circle.png"


const styles = {
    logo: {
        width: 130,
        height: 130,
    }
};

class Circle extends Component{
    
  
    render() {
       return( <div>
            <img style={styles.logo} src={circle} ></img>
        </div>
       )
    }
}export default Circle
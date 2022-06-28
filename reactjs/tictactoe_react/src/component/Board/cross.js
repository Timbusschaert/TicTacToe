import React ,{ Component } from "react";
import cross from "../../img/cross.png"


const styles = {
    logo: {
        width: 95,
        height: 95,
    }
};

class Cross extends Component{
    
  
    render() {
       return( <div>
            <img style={styles.logo} src={cross} ></img>
        </div>
       )
    }
}export default Cross
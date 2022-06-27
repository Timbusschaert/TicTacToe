import axios from 'axios'

export const HttpPost = async (url,params) =>{
    try{
        let response = null
        const config = {}
        response = await axios.post(url,params,config)
        return response.data
    }catch(err){
        if(!err.response){
            return null
        }
        return err.response.status
    }
}
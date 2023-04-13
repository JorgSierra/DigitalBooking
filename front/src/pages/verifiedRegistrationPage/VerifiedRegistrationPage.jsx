import React, {useState} from 'react'
import ResponsiveTemplate from '../../components/responsiveTemplate/ResponsiveTemplate'
import BlockVerified from '../../components/blockVerified/BlockVerified'


const VerifiedRegistrationPage = () => {
    const [messsage, setMessage] = useState("Su registro se ha realizado con éxito, revise su correo para habilitar su cuenta")

    return (
        <ResponsiveTemplate>
            <BlockVerified message={messsage} />
        </ResponsiveTemplate>
    )
}

export default VerifiedRegistrationPage
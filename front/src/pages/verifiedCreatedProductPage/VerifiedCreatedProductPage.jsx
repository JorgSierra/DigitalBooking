import React, {useState} from 'react'
import ResponsiveTemplate from '../../components/responsiveTemplate/ResponsiveTemplate'
import BlockVerified from '../../components/blockVerified/BlockVerified'


const VerifiedCreatedProductPage = () => {
    const [message, setMessage] = useState("Su producto se ha creado con éxito")

    return (
        <ResponsiveTemplate>
            <BlockVerified message={message} />
        </ResponsiveTemplate>
    )
}

export default VerifiedCreatedProductPage
import React, { useState } from 'react'
import BlockVerified from '../../components/blockVerified/BlockVerified'
import ResponsiveTemplate from '../../components/responsiveTemplate/ResponsiveTemplate'

const VerifiedReservationPage = () => {

    const [message, setMessage] = useState("Su reserva se ha realizado con éxito")

    return (
        <ResponsiveTemplate>
            <BlockVerified message={message} />
        </ResponsiveTemplate>
    )
}

export default VerifiedReservationPage
import React from 'react';
import AdminPolitics from '../adminPolitics/AdminPolitics';

const AdminRules = ({data}) => {
    // console.log(data)
  return (
    <>
    <h1>{data.tipolitica.nombre}</h1>
    <AdminPolitics data={data} key={data.id}/>
    </>
  )
}

export default AdminRules
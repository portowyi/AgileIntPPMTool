import React, { Component } from 'react'
import Header from './Layout/Header'
import ProjectItem from './Project/ProjectItem'

export default class Dashboard extends Component {
    render() {
        return (
            <div>
                <h1>Welcome to our APP</h1>
                <Header />
                <ProjectItem />
            </div> 
        )
    }
}

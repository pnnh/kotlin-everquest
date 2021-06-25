import React from "react";
import {
    BrowserRouter as Router,
    Switch,
    Route,
} from "react-router-dom";
import HomePage from "@/js/views/home/home-page";

import * as abc from 'everquest';
console.log("=====", abc);
import eq from 'everquest';
console.log("=====222", eq);
const encoder = eq.xyz.sfx.base64.Base64Factory.createEncoder();
if(encoder && encoder.encodeToString) {
    console.log("====333", encoder.encodeToString("哈哈哈哈"));
}

const App = () =>{
    return <Router>
                <Switch>
                    <Route path="/" component={HomePage} />
                </Switch>
        </Router>
}

export default App

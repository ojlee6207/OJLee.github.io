/*
    클래스형 컴포넌트(class component)
    - React.Component 클래스 상속
        import { Component } from 'react'
        class 컴포넌트명 extends Component {}
    - 상태(state)를 가지고 있다.(관리할 수 있다)
    - 생명 주기(Life cycle)에 따라 해당 메소드를 사용할 수 있다.
*/
// * React만 import 했을 때
// import React, { Component} from 'react';
// 상속 시 React.Component로 작성
// class ClassComponent extends React.Component

import {Component} from 'react';
class ClassComponent extends Component {
    // 초기화/생성자
    //  props : 부모요소로부터 전달받은 것들...(변수/함수/..);
    constructor(props) {
        super();

        this.state={
            message:"hi"
        }
    }

    // 클래스형 컴포넌트는 state를 가지고 있어 바로 사용이 가능
    // state 내에 객체 형태(key:value)로 상태를 관리할 수 있음
    componentDidMount() {
        this.setState({
            message: "나는 클래스형 컴포넌트입니다.!"        
        })
    }

    // 상태(값/데이터를 변경할 때)
    //  this.setState({변경할 변수명:변경할 값, 변경할변수2:변경값2, ...})

    // 클래스형 컴포넌트는 요소를 render() 메소드를 사용하여 받음
    render() {
        return (
            <>
                <button onClick={()=>{this.setState({message:"I'm class Component"})}}>내용 바꾸기</button>
                <p>
                    {this.state.message}
                </p>
            </>
        )
    }
}

export default ClassComponent;
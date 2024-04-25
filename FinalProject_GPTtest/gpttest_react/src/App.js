import './App.css';
import GptTest from './component/GptTest';
import React, {useState, useRef} from 'react';

function App() {
  const [modal, setModal] = useState(false);
  const modalBackground = useRef();

  return (
    <>
      <div>
        <button onClick={() => setModal(true)}>OpenModal</button>
        {
          modal && <div className="modal-overlay" ref={modalBackground}
          onClick={e => {if(e.target === modalBackground.current){
            setModal(false);
          }}}>
            <GptTest />
         </div>
        }
      </div>
    </>
  )
}

export default App;

import Board from '../components/Board';
import '../css/Game.css';

function Game() {
    const player = 'X';
    return (
        <>
            <p>Next Player: {player}</p>
            <Board />
        </>
    );
}

export default Game;
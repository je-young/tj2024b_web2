import { Link } from 'react-router-dom';

export default function SideBar(props) {
  console.log(props);
  return (
    <>
      <div>
        <ul>
          <li>사이드바 메뉴</li>
          <li>
            <a href="/">메뉴1 : HOME</a>
          </li>
          <li>
            <Link to="/create">메뉴2 : CREATE</Link>
          </li>
          <li>
            <Link to="/read">메뉴3 : READ</Link>
          </li>
          <li>
            <Link to="/update">메뉴4 : UPDATE</Link>
          </li>
          <li>
            <Link to="/delete">메뉴5 : DELETE</Link>
          </li>
        </ul>
      </div>
    </>
  );
}

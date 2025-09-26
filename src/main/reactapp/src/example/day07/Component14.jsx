import { useState } from 'react';
import Button from '@mui/joy/Button';
import Box from '@mui/joy/Box';
import Input from '@mui/joy/Input';
import Select from '@mui/joy/Select';
import Option from '@mui/joy/Option';
import Switch from '@mui/joy/Switch';
import Avatar from '@mui/joy/Avatar';
import SideBadr from './SideBar';


export default function Component14(props) {
    const handleChange = (event, newValue) => {
        alert(`You chose "${newValue}"`);
    };
    const [checked, setChecked] = useState(false);

    const [open, setOpen] = useState(false);
    const [open2, setOpen2] = useState(false);

    return (<>

        <h3>컴포넌트14</h3>
        <p> 1. 소문자 마크업 : html, 대문자 마크업 : 컴포넌트( 다른 패키지이면 import )</p>
        <button> html </button><br />
        <Button variant="solid">컴포넌트</Button>

        <p> 2. 마크업 속성 이란 : 마크업 안에, 마크업 속성명=속성값 </p>
        <h1> 버튼 : https://mui.com/joy-ui/react-button/ </h1>
        <Box sx={{ display: 'flex', gap: 2, flexWrap: 'wrap' }}>
            <Button>Button</Button>
            <Button disabled>Disabled</Button>
            <Button loading>Loading</Button>
        </Box>

        <h1> 3. 입력상자 : https://mui.com/joy-ui/react-input/ </h1>
        <Input placeholder="입력 하세요." />

        <h1> 4. 선택상자 : https://mui.com/joy-ui/react-select/ </h1>
        <Select defaultValue="dog" onChange={handleChange}>
            <Option value="dog">Dog</Option>
            <Option value="cat">Cat</Option>
            <Option value="fish">Fish</Option>
            <Option value="bird">Bird</Option>
        </Select>

        <h1> 5. 스위치 : https://mui.com/joy-ui/react-switch/ </h1>
        <Switch
            checked={checked}
            onChange={(event) => setChecked(event.target.checked)}
        />

        <h1> 6. 아바타 : https://mui.com/joy-ui/react-avatar/ </h1>
        <p> Box는 div 같은 유형, CSS적용하는 방법 : 1. CSS파일, 2. CSS객체 </p>
        <Box sx={{ display: 'flex', gap: 2}} style={{backgroundColor:'black'}}>
            <Avatar />
            <Avatar>JG</Avatar>
            <Avatar alt="Remy Sharp" src="/static/images/avatar/1.jpg" />
        </Box>

        <h1> 7. 리스트 : https://mui.com/joy-ui/react-list/</h1>
        <p> 아이콘 설치 : https://mui.com/material-ui/getting-started/installation/ </p>
        <SideBadr />
    </>)
    /*
        리액트에서 CSS적용하는 방법
            1) CSS파일 생성 한다. --> CSS 파일을 적용할 컴포넌트 에서 import
            2) CSS객체 --> 컴포넌트에서 객체유형으로 CSS 작성한다. <컴포넌트 style={{CSS카멜표기법}}
                주의할점 : -하이픈 대신에 카멜표기법 사용 한다.
                {font-size:"10"} -----> {fontSize:"10"}
    */
}
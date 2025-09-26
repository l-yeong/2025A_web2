import { Link, useNavigate } from "react-router-dom";
import Box from '@mui/joy/Box';
import Button from '@mui/joy/Button';
import ButtonGroup from '@mui/joy/ButtonGroup';
import IconButton from '@mui/joy/IconButton';
import Slider from '@mui/joy/Slider';
import Settings from '@mui/icons-material/Settings';
import { useState } from "react";

//store 저장된 상태를 가져오기

export default function Header(props) {
    const [hue, setHue] = useState(0);
    return (<>
        <h3>헤더 페이지</h3>
        <Box sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
            <Slider
                value={hue}
                min={0}
                max={360}
                valueLabelDisplay="on"
                valueLabelFormat={(value) => `hsl(${value} 100% 50%)`}
                onChange={(event, newValue) => setHue(newValue)}
            />
            <ButtonGroup
                variant="plain"
                aria-label="button group"
                sx={{ '--ButtonGroup-separatorColor': `hsl(${hue} 100% 50%) !important` }}
            >
                <Button><Link to="/">홈</Link></Button>
                <Button><Link to="/menu">메뉴</Link></Button>
                <Button><Link to="/cart">장바구니</Link></Button>
            </ButtonGroup>
        </Box>
    </>)
}//func end
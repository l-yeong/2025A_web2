import { useDispatch } from "react-redux"
import { menu } from '../store/cartslice.jsx'
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import List from '@mui/joy/List';
import ListItem from '@mui/joy/ListItem';
import ListSubheader from '@mui/joy/ListSubheader';
import ListItemButton from '@mui/joy/ListItemButton';
import Typography from '@mui/joy/Typography';
import Switch from '@mui/joy/Switch';
import Box from '@mui/joy/Box';
import Sheet from '@mui/joy/Sheet';
import Button from '@mui/joy/Button';
import RadioGroup from '@mui/joy/RadioGroup';
import Radio from '@mui/joy/Radio';

export default function MenuPage(props) {
    const [small, setSmall] = useState(false);
    const [variant, setVariant] = useState('solid');
    // 액변 하기 위한 dispatch 함수 가져오기
    const dispatch = useDispatch();

    // 가상URL로 페이지 전환하기 위한 navigate 함수 가져오기
    const navigate = useNavigate();

    const menuInfo = [
        { id: 1, name: "아메리카노", price: 3000 },
        { id: 2, name: "카페라떼", price: 4000 },
        { id: 3, name: "카푸치노", price: 4500 },
    ];

    const onMenu = async (item) => {
        alert("추가되었습니다");
        dispatch(menu(item)); //전역변수 상태변경
        navigate("/cart");  // 페이지 전환
    }
    return (<>
        <h3>메뉴페이지</h3>

        <div>
            <Switch
                size="sm"
                checked={small}
                onChange={(event) => setSmall(event.target.checked)}
                endDecorator={
                    <Typography level="body-sm">글자 사이즈</Typography>
                }
                sx={{ mb: 2 }}
            />
            <List
                variant="outlined"
                size={small ? 'sm' : undefined}
                sx={{ width: 500, borderRadius: 'sm' }}
            >
                <ListItem nested>
                    <ListSubheader>CoffeMenu</ListSubheader>
                    <List>
                        <ListItem>
                            <ListItemButton>
                                {menuInfo.map(m => (
                                    <div>{m.name} {m.price}원

                            
                                    
                                <Box sx={{ display: 'flex', alignItems: 'center', gap: 3 }}>
                                    <Box
                                        sx={{
                                            display: 'grid',
                                            gridTemplateColumns: 'repeat(2, minmax(80px, 1fr))',
                                            gap: 1,
                                        }}
                                    >
                                        <Button size="md" variant={variant} color="neutral" onClick={() => onMenu(m)}>
                                            추가
                                        </Button>
                                    </Box>
                                </Box>
                                </div>
                                ))}
                            </ListItemButton>
                        </ListItem>
                    </List>
                </ListItem>
            </List>
        </div>
    </>)
}//func end
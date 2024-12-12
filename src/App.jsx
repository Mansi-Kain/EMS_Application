import './App.css'
import ListEmployeeComponents from './Components/ListEmployeeComponents'
import { HeaderComponent } from './Components/HeaderComponent'
import { FooterComponent } from './Components/FooterComponent'
import { BrowserRouter , Routes,Route} from 'react-router-dom'
import AddEmployeeComponent from './Components/AddEmployeeComponent'

function App() {

  return (
    <>
    <BrowserRouter>
      <HeaderComponent/>
      <Routes>
        {/* //http://localhost:3000 */}
        <Route path='/' element={ <ListEmployeeComponents/> }></Route>
        {/* //http://localhost:3000/employees */}
        <Route path='/employees' element={<ListEmployeeComponents/>}></Route>
        {/* //http://localhost:3000/add-employee */}
        <Route path='/add-employee' element={<AddEmployeeComponent/>}></Route>
        {/* //http://localhost:3000/edit-employee */}
        <Route path='/edit-employee/:id' element={<AddEmployeeComponent/>}></Route>
      </Routes>
      <FooterComponent/>
    </BrowserRouter>    
    </>
  )
}

export default App

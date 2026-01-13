import { CAMERA_DATA } from "../../../lib/staticData"
import type { JSX } from "react"
import type { CameraInfo } from "../../../lib/type"
import CameraCard from "./CameraCard"
const DisplayImazingCameras = (): JSX.Element => {
  return (
    <div className="w-full mt-5 flex flex-col gap-10">
        {
            CAMERA_DATA.map((camera: CameraInfo)=>(
                <CameraCard 
                    key={camera.name} 
                    camera={camera} 
                />
            ))
        }
    </div>
  )
}

export default DisplayImazingCameras